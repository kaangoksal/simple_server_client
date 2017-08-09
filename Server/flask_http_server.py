from flask import Flask
from Server.User import User


app = Flask("Flask HTTP Server")

@app.route('/')
def index():
    return "This is the index!"

@app.route('/index')
def hello_world():
    return "Wassssuuup"

app.add_url_rule('/login', 'login', User.login, methods=['POST'])

if __name__ == "__main__":
    app.run(host="0.0.0.0",port=9000)