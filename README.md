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
    "name": "ชุดที่ 4 [Auto Generate Exam Type & Question Type]",
    "description": "ทดสอบข้อสอบที่ไม่มี ExamType จะต้อง Genrate Type เป็น Traditional อัตโนมัติ และถ้า QuestionType ไม่มีก็จะให้เป้น OBJECTIVE สำหรับตรวจแบบ Static อัตโนมัติ",
    "startAt": "2020-08-15T16:14:00.000Z",
    "endAt": "2020-11-30T16:14:00.000Z",
    "questions": [{
        "choices": [{
            "label": "Berlin",
            "isCorrectAnswer": false
        }, {
            "label": "Leipzig",
            "isCorrectAnswer": false
        }, {
            "label": "Munich",
            "isCorrectAnswer": true
        }, {
            "label": "Zurich",
            "isCorrectAnswer": false
        }],
        "type": "OBJECTIVE",
        "name": "3 If you want to avoid COVID-19, what place that you must not go?",
        "categories": [{
            "label": "computer",
            "backgroundColor": "#2d2a4a",
            "color": "#ffffff"
        }, {
            "label": "history",
            "backgroundColor": "#000000",
            "color": "#aaa"
        }],
        "_id": "5f1472ca1069a63ca32f7b46"
    }, {
        "choices": [{
            "label": "4",
            "isCorrectAnswer": true
        }, {
            "label": "5",
            "isCorrectAnswer": false
        }, {
            "label": "6",
            "isCorrectAnswer": false
        }, {
            "label": "7",
            "isCorrectAnswer": false
        }],
        "name": "2 x 2 = ?",
        "type": "OBJECTIVE",
        "categories": [{
            "label": "Mathematic",
            "backgroundColor": "#0d6efd",
            "color": "#ffffff"
        }, {
            "label": "Pre-Calculus",
            "backgroundColor": "#fd7e14",
            "color": "#ffffff"
        }],
	"_id": "5f1a6bb883c91b1c842caf24"
    }],
    "categories": [{
        "label": "ไม่รู้",
        "backgroundColor": "#6f42c1",
        "color": "#ffffff"
    }]
}
```