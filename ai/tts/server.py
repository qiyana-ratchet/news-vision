from flask import Flask,request
from kss_infer import do_synthesis,tacotron2,mb_melgan
import soundfile as sf

import requests
import json


app = Flask(__name__)

@app.post('/tts')
def test():
    #데이터를 json으로 받아온다.
    data = request.get_json()
    title = data['title']
    context = data['context']

    #volume에 저장할 file_path생성
    audio_path = '/workspace/ai/' + title +'.mp3'
    

    #inference
    input_text = context

    mels, alignment_history, audios = do_synthesis(input_text, tacotron2, mb_melgan, "TACOTRON", "MB-MELGAN")

    sf.write(audio_path, audios, 22050)
    

    # with open(file_path,'w') as file:
    #     json.dump(context,file)

    
    
    json_data = {'audio_path': audio_path}
    res = requests.post('http://nginx/wave2lip', json=json_data)

    return res.file_path



if __name__=='__main__':
    app.run()
