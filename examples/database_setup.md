# Database Setup

### ตัวอย่างการติดตั้ง MongoDB โดยใช้ Docker
```sh
docker run --name depa-mongodb -dit -p 27017:27017 mongo:4.0-xenial
```

### ตัวอย่างการติดตั้ง MySQL (MariaDB) โดยใช้ Docker
```sh
docker run --name=depa-mariadb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=depa-form -p 3306:3306 -d mariadb:10.2
```

การติดตั้ง phpMyAdmin เพื่อช่วยจัดการ MySQL Database ได้ง่ายขึ้นผ่าน Web UI
```sh
docker run --name depa-phpmyadmin -d --link depa-mariadb:db -p 8080:80 phpmyadmin/phpmyadmin
```