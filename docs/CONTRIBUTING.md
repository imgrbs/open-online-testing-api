# Contributing to Open Online Testing Service - API

ยินดีต้อนรับเข้าสู่ Open Online Testing Service - API เนื้อหาส่วนนี้จะช่วยให้คุณเห็นภาพและเข้าใจว่าจะเข้ามามีส่วนร่วมกับโปรเจกต์นี้ได้อย่างไร ไปดูกัน

### สารบัญ

* [Code of Conduct](#code-of-conduct)
* [มาลองสร้าง Pull Request แรกกัน](#มาลองสร้าง-pull-request-แรกกัน)
* [ขั้นตอนการพัฒนา](#ขั้นตอนการพัฒนา)
  * [ข้อตกลงในการโค้ดโปรเจกต์นี้](#ข้อตกลงในการโค้ดโปรเจกต์นี้)
  * [รูปแบบ Commit Message](#รูปแบบ-commit-message)
  * [Subsystems ของระบบ](#subsystems-ของระบบ)
  * [โครงสร้างของโปรเจกต์](#โครงสร้างของโปรเจกต์)
* [การออกแบบเชิงสถาปัตยกรรมระบบ](#การออกแบบเชิงสถาปัตยกรรมระบบ)
* [การส่ง Pull Request](#การส่ง-pull-request)
* [Become a maintainer](become-a-maintainer)

## Code of Conduct

Open Online Testing Service - API  ได้นำ Code of Conduct จาก [Contributor Covenant](https://www.contributor-covenant.org/) มาปรับใช้ และเราคาดหวังว่าผู้ที่เข้ามาส่วนรวมกับโปรเจกต์จะยึดมั่นในสิ่งนี้
ดังนั้นการที่คุณอ่าน [code of conduct ที่ลิงก์นี้](/docs/CODE_OF_CONDUCT.md) จะช่วยให้คุณเข้าใจว่าสิ่งไหนควรทำและสิ่งไหนที่ไม่

## มาลองสร้าง Pull Request แรกกัน

พึ่งเคย Pull Request ครั้งแรกหรือเปล่า ?
ลองดูวิดีโอที่จะช่วยอธิบายวิธีการ Contribute Open Source โปรเจกต์บน GitHub นี่สิ

https://egghead.io/courses/how-to-contribute-to-an-open-source-project-on-github

## ขั้นตอนการพัฒนา

หลังจากคุณ pull โค้ดมาไว้ที่เครื่องของคุณแล้ว 

ให้รันคำสั่งดังนี้
```sh
docker-compose -f docker-compose.dev.yml build
docker-compose -f docker-compose.dev.yml up
```

คำสั่งด้านบนจะสร้าง 2 services นั่นคือ 
* mongo database บน localhost:27017 
* backend service หรือ depa-testing-api บน localhost:8080

### ข้อตกลงในการโค้ดโปรเจกต์นี้

เพื่อให้ผู้ใช้มั่นใจได้ว่าซอร์สโค้ด มีความสอดคล้องกันตลอด จึงมีข้อตกลงในการทำงานร่วมกันคือ

* ทุก ๆ  ฟีเจอร์หรือบั๊ก **จะต้องมีเทส** อย่างน้อย 1 test case หรือมากกว่า (unit-tests)
* ทุก ๆ public API methods **จะต้องมี document**

### รูปแบบ Commit Message

การที่มีการจัดการ commit message ให้เหมือนกันทั้งหมดเพื่อให้ **ง่ายต่อการอ่านประวัติ commit**
โดยในแต่ละ commit message อาจแบ่งออกเป็น 3 ส่วน ได้แก่ header body และ footer

```
<header>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

`header` เป็นส่วนที่จำเป็นต้องมี
`body` มีหรือไม่มีก็ได้ 
`footer` มีหรือไม่มีก็ได้ 

#### Commit Message Header

```
[type] <short summary>
 │       │
 │       │
 │       └─⫸ อธิบายให้อยู่ในรูปแบบ present tense ไม่ต้องมี capitalzed (ไม่ต้องมีตัวพิมพ์ใหญ่) ไม่ต้องมีจุดปิดท้าย (.)
 │
 └─⫸ ประเภทของ commit: [ADD]|[UPDATE][REMOVE]
```

**Type**
จะต้องอยู่ในรายการด้านล่าง ตัวใดตัวหนึ่ง
* [ADD] การเพิ่มไฟล์ หรือฟีเจอร์ใหม่
* [UPDATE] การแก้ไขไฟล์ แก้บั๊ก
* [REMOVE] การลบไฟล์ หรือลบโค้ดส่วนใดส่วนนึงออก

**Summary**

อธิบายการเปลี่ยนแปลงที่เกิดขึ้นใน commit นั้น ๆ อย่างรวบรัด ให้ได้ใจความว่าทำอะไร ทำไปทำไม

* ให้ใช้ประโยคอยู่ในรูปแบบของ present tense เช่น "change" ไม่ใช่ "changed" หรือ "changes"
* ต้องไม่เป็นตัวพิมพ์ใหญ่ขึ้นต้น (do not capitalized)
* ไม่ต้องมีจุดปิดท้าย (.)

#### Commit Message Body

เป็นส่วนอธิบายรายละเอียดเพิ่มเติม ที่อาจเขียนจาก header ไม่หมด
ส่วนของรูปแบบประโยคให้เป็นในลักษณะเดียวกันกับ summary คือให้ใช้เป็น present tense: "fix" ไม่ใช่ "fixed" หรือ "fixes"

#### Commit Message Footer

แปะ reference ของ GitHub issues, Jira ticket, หรือจากระบบอื่น ที่ commit นั้นเกี่ยวข้อง

```
[type]: <change summary>
<BLANK LINE>
<change description>
<BLANK LINE>
<BLANK LINE>
Fixes #<issue number>
```

### Subsystems ของระบบ

Subsystems ระบบประกอบด้วย 4 ส่วนหลัก ได้แก่
1. User Management - มีหน้าที่สร้างและจัดการ user และสิทธิ์การใข้งานระบบ
2. Testpool Management - มีหน้าที่สร้างและจัดการโจทย์ นำโจทย์มาสร้างข้อสอบ และจัดการข้อสอบ
3. Examination Management - มีหน้าที่จัดการคนเข้าสอบ และจัดการการสอบ
4. (🚧 ยังไม่ถูกพัฒนา) Grading - มีหน้าที่ประเมินผลและประกาศคะแนน

โดยส่วนย่อยของระบบทั้ง 4 นั้นเมื่อนำมาแสดงความสัมพันธ์  dependencies ได้ดังภาพด้านล่าง ซึ่งแต่ละส่วนมี Concern เป็นของตัวเองและแตกต่างกันโดยออกแบบแต่ละส่วนด้วยการใช้หลัก Separation of Concerns

![Overview Testing System  - Seperation of Concern](https://user-images.githubusercontent.com/22396258/93709639-0d82c300-fb6a-11ea-9b03-9b65cf12d216.png)

### โครงสร้างของโปรเจกต์

```
open-online-testing-api
├── src
│   ├── main
│   │   ├── java.com.depa.exam
│   │   │                 ├── TestingSystemApplication.java
│   │   │                 ├── controller
│   │   │                 ├── dto
│   │   │                 ├── model
│   │   │                 ├── repository
│   │   │                 └── service
│   │   └── resources
│   │       └── application.properties
│   └── test.java.com.depa.exam
│                          ├── controller
│                          ├── dto
│                          ├── model
│                          └── service
└── ...
```

* `src/main/.../exam/controller` เก็บไฟล์ของ controller layer
* `src/main/.../exam/dto` เก็บไฟล์ data to object (DTO) เป็นไฟล์ที่เกี่ยวกับการ mapper request และ response จาก controller
* `src/main/.../exam/model` เก็บไฟล์ model ตาม business logic
* `src/main/.../exam/repository` เก็บไฟล์ repository ที่เกี่ยวข้องกับการติดต่อข้อมูล database หรือ external source
* `src/main/.../exam/service` เก็บไฟล์ของ service layer
* `src/main/resources/application.properties` เก็บการตั้งค่าที่เกี่ยวข้องกับแอปพลิเคชันนั้น ๆ

* `src/test/.../exam/` เก็บไฟล์ test ลักษณะการเขียนจะเป็น parallel กับ main package

## การออกแบบเชิงสถาปัตยกรรมระบบ

สามารถดูรายละเอียดการออกแบบสถาปัตยกรรมของระบบ Open Online Testing System (OOTS) ได้ที่ [WIKI](https://github.com/imgrbs/open-online-testing-api/wiki)

## การส่ง Pull Request

ช่วยส่ง Pull Request มาเล็ก ๆ อย่าทำมากกว่า 1 หรือแก้บั๊กในหลาย ๆ เรื่องจาก 1 Pull Request
มันจะดีมากหากเปิด Issue ก่อนเพื่อให้คนอื่น ๆ ทราบว่าคุณกำลังทำฟีเจอร์อะไรอยู่
depa-testing-api ถูกสร้างมาให้กับ community ดังนั้นเรา

## Become a maintainer

หากคุณสนใจและคิดว่าโปรเจกต์นี้เป็นประโยชน์ และอยากร่วมพัฒนากับเรา ติดต่อมาหาเรา

ขอให้โค้ดอย่างมีความสุข!
