from flask import Flask,request
import requests
import json

app = Flask(__name__)

@app.post('/tts')
def test():
    #데이터를 json으로 받아온다.
    data = request.get_json()
    title = data['title']
    context = data['context']

    #volume에 그대로 저장한다.
    
    file_path = '/app/data/' + title
    with open(file_path,'w') as file:
        json.dump(context,file)

    
    
      #reqeusts. file_path만 적어서 날려준다.
    json_data = {'file_path': file_path}
    res = requests.post('http://nginx/wave2lip', json=json_data)

    return res.text




if __name__=='__main__':
    app.run()
