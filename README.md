# Depa Form Project API
- description

# System Requirements
- java 11
- maven
- intellij (recommended) *or netbean*
- docker

# Database Installl
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