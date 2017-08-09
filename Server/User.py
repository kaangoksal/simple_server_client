
from flask import request
import json


class User():

    @staticmethod
    def login():
        parsed_json = request.get_json()
        email = parsed_json["email"]
        password = parsed_json["password"]

        if email == "ladd@toor.com" and password == "Trump_hates_foreigners":
            json_dictionary = {'code': 200, 'message': "login successful"}
            return_string = json.dumps(json_dictionary, sort_keys=True, indent=4, separators=(',', ': '))
            print("Client login attempt successful")
            return return_string

        else:
            json_dictionary = {'code' : 31, 'message':"login unsuccessful"}
            return_string = json.dumps(json_dictionary, sort_keys=True, indent=4, separators=(',', ': '))
            return return_string