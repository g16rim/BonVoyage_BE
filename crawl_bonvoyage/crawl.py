import pymysql
import requests
# from bs4 import BeautifulSoup as bs
import json

serviceKey = ''
rType = 'json'
num = '32'
url = 'https://apis.data.go.kr/B551011/KorService1/searchStay1?serviceKey=' + serviceKey + '&numOfRows=500&pageNo=2&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A'

res = requests.get(url).text
data = json.loads(res)
stays = data["response"]["body"]["items"]["item"]
stay_list = []
i = 0
# print(stays)
for stay in stays:
    name = stay["title"]
    type = 0
    sitePictureUrl = stay["firstimage"]
    phone = stay["tel"]
    latitude = stay["mapx"]
    longitude = stay["mapy"]
    print(name, type, sitePictureUrl, phone, latitude, longitude)
    stay_list.append(tuple([name, type, sitePictureUrl, phone, latitude, longitude]))
    i += 1
print(i)

def mysql_save(data):
    conn = pymysql.connect(host='localhost', user='ssafy', password='ssafy', db='trip', charset='utf8')
    cursor = conn.cursor()
    sql = "insert into travelsite(name, type, sitePictureUrl, phone, latitude, longitude) values(%s, %s, %s, %s, %s, %s)"
    cursor.executemany(sql, data)
    conn.commit()
    conn.close()
mysql_save(stay_list)