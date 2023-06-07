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
    title = data['p_title']
    context = data['p_content']
    genre = data['genre']

    #volume에 저장할 file_path생성
    audio_path = '/workspace/voice/' + title +'.mp3'
    

    #inference
    input_text = context

    mels, alignment_history, audios = do_synthesis(input_text, tacotron2, mb_melgan, "TACOTRON", "MB-MELGAN")

    try:
        sf.write(audio_path, audios, 22050)
    except Exception as e:
        print(f"An error occurred while writing the audio file: {str(e)}")
    

    # with open(file_path,'w') as file:
    #     json.dump(context,file)

    voice_path= '/workspace/video/'+ title +'.mp3'
    
    
    json_data = {'audio_path': voice_path,'title': title, 'genre': genre}

    try:
        res = requests.post('http://news-alb-rest-1045794844.ap-northeast-2.elb.amazonaws.com/wav2lip', json=json_data)
        res.raise_for_status()  # 요청이 실패한 경우 예외 발생
        return res.text
    except requests.exceptions.RequestException as e:
        error_msg = "요청을 보낼 수 없습니다: {}".format(e)
    except requests.exceptions.HTTPError as e:
        error_msg = "HTTP 오류가 발생하였습니다: {}".format(e)
    except requests.exceptions.ConnectionError as e:
        error_msg = "서버에 연결할 수 없습니다: {}".format(e)
    except Exception as e:
        error_msg = "예외가 발생하였습니다: {}".format(e)

    print(error_msg)
    return error_msg


@app.get('/tts/health')
def health():
    return 'ok';


if __name__=='__main__':
    app.run()
