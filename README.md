# Open Online Testing Service - API

เป็นระบบสร้างและจัดการข้อสอบ
เป็นระบบที่ให้ผู้ออกข้อสอบ สามารถออกโจทย์ได้ แล้วนำโจทย์ต่าง ๆ มาประกอบกันเป็นข้อสอบ แล้วจึงนำข้อสอบไปให้คนสอบ

### ระบบนี้ประกอบด้วย 2 ส่วนใหญ่ ๆ คือ

1. Backend Service - ให้บริการตาม function ของระบบ depa testing ทั้งหมด แต่จะไม่มีส่วนของ User Interface (UI) จะขอเรียกส่วนนี้ว่า [Open Online Testing Service - API](https://github.com/imgrbs/open-online-testing-api)
2. Frontend Service - เป็น User Interface ของระบบซึ่งเรียกใช้ Backend Service เพื่อให้บริการแก่ User จะขอเรียกส่วนนี้ว่า [Open Online Testing Service - Web](https://github.com/bazsup/open-online-testing-web)

### สารบัญ

- [ลักษณะการใช้งานระบบ](#ลักษณะการใช้งานระบบ)
- [การนำไปใช้งาน](#การนำไปใช้งาน)
- [ความต้องการของระบบ](#ความต้องการของระบบ)
- [Contribution](#Contribution)
- [LICENSE](#LICENSE)
- [Contributors](#Contributors)

## ลักษณะการใช้งานระบบ

- 1 Backend รองรับหลาย ๆ Frontend ได้
- 1 Frontend รองรับหลาย ๆ หน่วยงานได้
- Frontend กับ Backend อยู่ Server เดียวกันหรือต่างกันก็ได้

![Overview Testing System  - ServiceType](https://user-images.githubusercontent.com/22396258/93670573-84668000-fac6-11ea-957f-d2a82a84913b.png)

## การนำไปใช้งาน

- เบื้องต้นรองรับการสร้างคำถามประเภทปรนัย (แบบตัวเลือก) และอัตนัย (แบบบรรยาย)
- รองรับการสร้างข้อสอบโดยเป็นการดึงกลุ่มของคำถามที่ถูกสร้าง
- รองรับการเข้าสู่ระบบ 3 วิธี
  - Username & Password
  - Google Authentication
  - Facebook Authentication

สามารถดู URL และ method ที่ให้บริการได้ที่ [GitHub Wiki](https://github.com/imgrbs/open-online-testing-api/wiki)

## ความต้องการของระบบ

- java 11
- maven
- docker

## Infrastructer Diagram
Container Image
(https://hub.docker.com/repository/docker/linxianer12/open-online-testing-api)
Backend URL:

ระบบจะประกอบไปด้วยเครื่อง Jenkins สำหรับใช้ในการ Deploy ซึ่งสำหรับวิธีการ Config นั้นจะมีคำอธิบายอยู่ที่
ติดตั้ง Code Ready Container หรือ Minikube สำหรับการใช้ Run ใน Local Environment ซึ่ง Code Ready Container นั้นจะให้ Environment เสมือนโปรแกรมทำงานอยู่บน Openshift จริงๆ หรือจะใช้เป็น Minikube ก็ได้เช่นกัน


## Contribution

เรายินดีเป็นมาสำหรับการมาร่วม contribute ให้กับโปรเจกต์ ไม่ว่าด้านใด สำหรับรายละเอียดดูได้ที่ 👉 [Contribution](/docs/CONTRIBUTING.md)

## LICENSE

โปรเจกต์ชิ้นนี้อยู่ภายสัญญาอนุญาติซอฟต์แวร์เสรี [MIT license](/LICENSE)

## Contributors

ขอบคุณบุคคลเหล่านี้ ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/imgrbs">
        <img src="https://avatars2.githubusercontent.com/u/11602960?u=e08ffeedc189ba4efc87af5452ccc2ca839f0cee&v=4" width="100px;" alt="" /><br />
        <b>ImagineRabbits</b><br />
        <a href="https://github.com/imgrbs/open-online-testing-api/commits?author=imgrbs" title="Code">💻</a>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/bazsup">
        <img src="https://avatars2.githubusercontent.com/u/22396258?u=6e1fb78f3196e20d093c98d205debb10ef5e5d4e&v=4" width="100px;" alt="" /><br />
        <b>Supawit</b><br />
        <a href="https://github.com/imgrbs/open-online-testing-api/commits?author=bazsup" title="Code">💻</a>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/wdrdres3qew5ts21">
        <img src="https://avatars2.githubusercontent.com/u/25000903?u=622a8832381cbddd89795db393a9e8d5b1e347df&v=4" width="100px;" alt="" /><br />
        <b>Naomi Lin</b><br />
        <a href="https://github.com/imgrbs/open-online-testing-api/commits?author=wdrdres3qew5ts21" title="Code">💻</a>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/bigzaja4">
        <img src="https://avatars2.githubusercontent.com/u/24911638?u=3e3e61a6335f335ae16187dff3b4348f660f4ab7&v=4" width="100px;" alt="" /><br />
        <b>Biggie</b><br />
        <a href="https://github.com/imgrbs/open-online-testing-api/commits?author=bigzaja4" title="Code">💻</a>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/mixkungz">
        <img src="https://avatars2.githubusercontent.com/u/20185035?u=99b107326654533f94afc5d4524cd4ff31722f2b&v=4" width="100px;" alt="" /><br />
        <b>
Phachara Kamthong</b><br />
        <a href="https://github.com/imgrbs/open-online-testing-api/commits?author=mixkungz" title="Code">💻</a>
      </a>
    </td>
  </tr>
</table>
