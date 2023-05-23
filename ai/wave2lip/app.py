from flask import Flask,request


app = Flask(__name__)

@app.post('/wave2lip')
def test2():
    data = request.get_json()
    file_path = data['file_path']

    with open(file_path,'r') as file:
        file_content = file.read()

    return file_content

if __name__=='__main__':
    app.run()



    


