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

### ความต้องการของ dependency
- Docker for desktop v1.18.8 (เปิดใช้งาน Kubernetes)/ Code Ready Container (OKD 4)
- Istioctl Binary version v1.6


(https://i.ibb.co/zR42H0S/Infrastructure-Diagram-Page-2.png)
ระบบจะประกอบไปด้วยเครื่อง Jenkins สำหรับใช้ในการ Deploy ซึ่งสำหรับวิธีการ Config นั้นจะมีคำอธิบายอยู่ที่
ติดตั้ง Code Ready Container หรือ Minikube สำหรับการใช้ Run ใน Local Environment ซึ่ง Code Ready Container นั้นจะให้ Environment เสมือนโปรแกรมทำงานอยู่บน Openshift จริงๆ หรือจะใช้เป็น Minikube ก็ได้เช่นกัน
ซึ่งสำหรับรายละเอียด Process ของ DevOps อย่างละเอียดสามารถอ่านได้ที่
โดยเราจะทำการติดตั้งโปรแกรมผ่านคำสั่ง และให้เราทำการแก้ไข Environment ใน Configmap และ Secret ของ Kubernetes ให้ถูกต้องตามความต้องการใช้งานของเรา
ซึ่งการที่เราแยก Configuration ออกมาอีก Layer หนึ่งนั้นจะทำให้ Application ของเราได้คุณสมบัติของความเป็น 12 Factors มากยิ่งขึ้น และมีความยิดหยุ่นในเชิงของการออกแบบ Software Architect 

### การติดตั้ง Secret และ ConfigMap ผ่าน Imperative CommandLine

```
 kubectl create configmap depa-backend-configmap --from-literal="SECURITY_REDIRECT_URI=depa-frontend-service:3000/oauth2/redirect"  --from-literal="AUTOHRIZED_REDIRECT_URIS=depa-frontend-service:3000/oauth2/redirect"  --from-literal="BASE_URL=depa-frontend-service:3000/oauth2/redirect" --dry-run=client -oyaml | kubectl apply -f -

kubectl create secret generic depa-backend-secret --from-literal="MONGO_PASSWORD=your_password"  --from-literal="FACEBOOK_ID=facebook_id"  --from-literal="FACEBOOK_SECRET=your_facebook_secret"  --from-literal="GOOGLE_ID=419816776318-qfu7r0npl3e28vlv57v51t6110tqjb9p.apps.googleusercontent.com"  --from-literal="GOOGLE_SECRET=your_google_secret"  --dry-run=client -oyaml | kubectl apply -f -
```
เราสามารถใช้ Command เพื่อสร้าง ConfigMap และ Secret โดยสังเกตดูที่คำสั่ง -oyaml นั้นหมายถึง output จะออกมาเป็น yaml file เราสามารถนำผลลัพธ์จากคำสั่งนี้มาบันทึกเป็นไฟล์จริงๆในเครื่องก็ได้โดยการเพิ่ม redirection 
ดั่งเช่นคำสั่งนี้แทนการ pipe ไปหา คำสั่ง kubectl apply -f - และเราจะได้ไฟล์มาไว้ใช้ในครั้งหน้าต่อไปได้
** ... หมายถึงการ repeat argument ดั่งข้างต้นทั้งหมด
```
kubectl create configmap depa-backend-configmap ... -oyaml    > configmap.yaml

kubectl create secret generic depa-backend-secret ... -oyaml  > secret.yaml
```

### การติดตั้ง Application ใน Kubernetes Cluster
ส่วนการใช้
```
kubectl apply -f configmap.yaml

kubectl apply -f secret.yaml

kubectl apply -f deployment-production.yaml

kubectl apply -f k8s-service-production.yaml
```

1. ConfigMap นั้นใช้สำหรับเก็บ Envionment Variable ของ Container ที่เราใช้งานเช่น URL ของ OAuth Redirection
2. Secret นั้นมีลักษณะเหมือนกับ ConfigMap เพียงแต่จะใช้ในการเก็บข้อมูลที่มีความ sensitive เช่นรหัส Database ซึ่งจะถูก Encode ด้วย Base64 (ไม่ได้ทำ Encryption ให้ปลอดภัยแต่แค่ช่วยในการทำ Confusion ไม่ให้เผลอเห็นโดยตรงเฉยๆ ถ้าอยากเพิ่มความปลอดภัยอีกระดับหนึ่งเราก็จะต้องมี Account ที่มี Permission ต่ำๆที่ไม่สามารถอ่าน secret จาก namespace ได้)
3. Deployment คือการ Configuration Container ว่าราละเอียดของ Image ที่มาใช้รายละเอียดของ Port ต่างๆ
4. Service คือ DNS Resolution ใน Kubernetes Cluster ซึ่งใช้ในการทำ Service Discovery ให้เราสามารถ Request endpoint ของ Application ที่เรา Deploy ใน Cluster ผ่าน DomainName แทนการเรียกผ่าน IP แทนนั้นเอง 


สำหรับการติดตั้ง Service Mesh ใน Kubernetes นั้นเราจะเลือกเป็น Istio Version 1.6 หรือจะใช้ Version มากกว่านี้ก็ได้แต่ผู้เขียนทดลองบน Version 1.6 ภายใต้ Environment ของ Azure Kubernetes Service
```
linxianer12@Laptop:~$ kubectl version -oyaml
clientVersion:
  buildDate: "2020-08-13T16:12:48Z"
  compiler: gc
  gitCommit: 9f2892aab98fe339f3bd70e3c470144299398ace
  gitTreeState: clean
  gitVersion: v1.18.8
  goVersion: go1.13.15
  major: "1"
  minor: "18"
  platform: linux/amd64
serverVersion:
  buildDate: "2020-06-24T19:54:11Z"
  compiler: gc
  gitCommit: 5737fe2e0b8e92698351a853b0d07f9c39b96736
  gitTreeState: clean
  gitVersion: v1.17.7
  goVersion: go1.13.6
  major: "1"
  minor: "17"
  platform: linux/amd64

  linxianer12@Laptop:~$ istioctl version -oyaml
clientVersion:
  golang_version: go1.14.2
  revision: f508fdd78eb0d3444e2bc2b3f36966d904c5db52-dirty
  status: Modified
  tag: 1.6.5
  version: 1.6.5

dataPlaneVersion:
- ID: depa-backend-deployment-68555c584d-8hnfw.default
  IstioVersion: 1.6.5
- ID: redis-slave-0.default
  IstioVersion: 1.6.5
- ID: depa-backend-deployment-refactor-6775cd6ddb-tnc7t.default
  IstioVersion: 1.6.5
- ID: depa-backend-deployment-master-76f444758c-mptdk.default
  IstioVersion: 1.6.5
- ID: istio-ingressgateway-54c6695cdd-nchfx.istio-system
  IstioVersion: 1.6.5
- ID: depa-backend-deployment-final-568c4cb8cf-jz5l2.default
  IstioVersion: 1.6.5
- ID: depa-backend-deployment-refactor-6775cd6ddb-5kpnd.default
  IstioVersion: 1.6.5
- ID: details-v1-78db589446-rphtj.microservice
  IstioVersion: 1.6.5
- ID: depa-frontend-deployment-5969789d64-crkkf.default
  IstioVersion: 1.6.5
- ID: mysql-7b794c7595-q78kh.default
  IstioVersion: 1.6.5
- ID: istio-egressgateway-57b9c7d65b-2qrz4.istio-system
  IstioVersion: 1.6.5
- ID: kong-kong-6f784b6686-bdrmj.kong
  IstioVersion: 1.6.5
- ID: prometheus-7d8596bd56-8pz2d.istio-system
  IstioVersion: 1.6.5
meshVersion:
- Component: pilot
  Info:
    golang_version: go1.14.2
    revision: f508fdd78eb0d3444e2bc2b3f36966d904c5db52-dirty
    status: Modified
    tag: 1.6.5
    version: 1.6.5
```
1. ให้ทำการโหลด binary สำหรับ execute มาจาก Istio และทำการวางไฟล์ execute ไว้ยัง Directory ที่ต้องการและเซ็ท environment PATH ของเครื่องให้ชี้ไปยัง directory ของเรา
2. ทดสอบว่าสามารถ Execute Binary ได้หรือไม่ผ่านการเรียกใช้คำสี่ง istioctl 
```
istioctl version -oyaml

istioctl install 
# หลังจากติดตั้ง istio แล้วเราต้องทำการแปะ label istio-injection=enabled ด้วยเพื่อให้ istio ทำการ inject side-car ไปยัง Namespace นั้น

kubectl label namespace default --label istio-injection=enabled

kubectl apply -f servicemesh/backend-servicemesh.yaml
# ติดตั้ง Service Mesh ทั้งหมดที่มีในระบบ
```


Istio นั้นจะมีการทำงานดั่งบทความนี้

สำหรับการทำ CI/ CD นั้นก็จะมีการออกแบบดั่งบทความนี้



## Contribution

เรายินดีเป็นมาสำหรับการมาร่วม contribute ให้กับโปรเจกต์ ไม่ว่าด้านใด สำหรับรายละเอียดดูได้ที่ 👉 [Contribution](/docs/CONTRIBUTING.md)

## LICENSE

สัญญาการอนุญาตของซอฟต์แวร์อยู่ภายใต้เงื่อนไขของ [MIT license](/LICENSE)

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
