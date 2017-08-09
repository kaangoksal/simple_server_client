import requests
import json

class client():
    @staticmethod
    def login(email, password, server_addr):
        headers = {'Content-Type': "application/json"}
        return_json = {'email': email, 'password': password}
        return_string = json.dumps(return_json, sort_keys=True, indent=4, separators=(',', ': '))

        r = requests.post(server_addr + '/login', data=return_string, headers=headers)
        parsed_json = json.loads(r.text)
        return parsed_json




server_address = "http://localhost:9000"
email = "ladd@toor.com"
password = "Trump_hates_foreigners"

print(client.login(email, password,server_address))