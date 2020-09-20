# Depa Form Project API
- description

# System Requirements
- java 11
- maven
- intellij (recommended) *or netbean*
- docker

# Database Installation (MongoDB)
```
docker run --name depa-mongodb -dit -p 27017:27017 mongo:4.0-xenial
```

# Database Installation (MYSQL)
```
docker run --name=depa-mariadb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=depa-form -p 3306:3306 -d mariadb:10.2

docker run --name depa-phpmyadmin -d --link depa-mariadb:db -p 8080:80 phpmyadmin/phpmyadmin
```

# Environment Variables
```
DB_HOST=localhost:3306;
DB_DATABASE=depa-form;
DB_USERNAME=root;
DB_PASSWORD=root;
```
```
{
    "id": {
        "timestamp": 1600604621,
        "counter": 6544741,
        "time": 1600604621000,
        "date": "2020-09-20T12:23:41.000+0000",
        "timeSecond": 1600604621,
        "machineIdentifier": 8667758,
        "processIdentifier": 25204
    },
    "name": "ชุดที่ 4 [Auto Generate Exam Type & Question Type]",
    "description": "ทดสอบข้อสอบที่ไม่มี ExamType จะต้อง Genrate Type เป็น Traditional อัตโนมัติ และถ้า QuestionType ไม่มีก็จะให้เป้น OBJECTIVE สำหรับตรวจแบบ Static อัตโนมัติ",
    "questions": [
        {
            "id": null,
            "name": "3 If you want to avoid COVID-19, what place that you must not go?",
            "type": "OBJECTIVE",
            "attributes": null,
            "choices": [
                {
                    "label": "Berlin",
                    "isCorrectAnswer": false
                },
                {
                    "label": "Leipzig",
                    "isCorrectAnswer": false
                },
                {
                    "label": "Munich",
                    "isCorrectAnswer": true
                },
                {
                    "label": "Zurich",
                    "isCorrectAnswer": false
                }
            ],
            "categories": [
                {
                    "id": null,
                    "label": "computer",
                    "backgroundColor": "#2d2a4a",
                    "color": "#ffffff"
                },
                {
                    "id": null,
                    "label": "history",
                    "backgroundColor": "#000000",
                    "color": "#aaa"
                }
            ]
        },
        {
            "id": null,
            "name": "2 x 2 = ?",
            "type": "OBJECTIVE",
            "attributes": null,
            "choices": [
                {
                    "label": "4",
                    "isCorrectAnswer": true
                },
                {
                    "label": "5",
                    "isCorrectAnswer": false
                },
                {
                    "label": "6",
                    "isCorrectAnswer": false
                },
                {
                    "label": "7",
                    "isCorrectAnswer": false
                }
            ],
            "categories": [
                {
                    "id": null,
                    "label": "Mathematic",
                    "backgroundColor": "#0d6efd",
                    "color": "#ffffff"
                },
                {
                    "id": null,
                    "label": "Pre-Calculus",
                    "backgroundColor": "#fd7e14",
                    "color": "#ffffff"
                }
            ]
        }
    ],
    "categories": [
        {
            "id": null,
            "label": "ไม่รู้",
            "backgroundColor": "#6f42c1",
            "color": "#ffffff"
        }
    ],
    "startAt": null,
    "endAt": null,
    "type": "TRADITIONAL"
}
```