## 자주 사용하는 라이브러리 정리

 현재 직접 안드로이드 프로젝트에서 사용하고 있는 라이브러리들에 대한 정리.

### GSON 

 GSON 라이브러리는 JSON 형식을 객체 형식으로 또는 객채형식을 JSON 형식으로 바꾸는 데 사용한다. 

 진행중인 프로젝트에서는 객체형식의 데이터를 JSON 형식으로 변환해 Database 에 올리거나 Database에서 가져올 때 JSON 형식으로 불러와 GSON 을 통하여 객체 형식으로 전환하는데 사용한다.

> Get Started
>
> ` implementation 'com.google.code.gson:gson:2.8.6'` 
>
> Using function
>
> `toJson() , fromJson()`
>
> Example
>
> ```java
> Gson gson = new Gson();
> OtherClass otherClass = new OtherClass(); // OtherClass 선언
> String json = gson.toJson(otherClass); // OtherClass의 변수들을 toJson을 사용하여 json 문자열에 JSON 형식으로 넣음
> int new_value_1 = gson.fromJson(json,OtherClass.class).value1; // fromJson을 사용하여 json 형식을 객체형식으로 변환해 필요한 값을 가져옴
> ```
>
> Reference
>
> <https://github.com/google/gson>



### Tedpermission

 Tedpermission 라이브러리는 **Android 6.0(marshmallow)** 부터 사용된 권한에 대한 라이브러리이다. 

>Get Started
>
>`implementation 'gun0912.ted:tedpermission:2.1.1`
>
>```
><uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
><uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
><uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
>```
>
>Example
>
>```java
>PermissionListener permissionlistener = new PermissionListener() {
>        @Override
>        public void onPermissionGranted() {
>            Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
>        }
>
>        @Override
>        public void onPermissionDenied(List<String> deniedPermissions) {
>            Toast.makeText(MainActivity.this, "Permission Denied\n" + deniedPermissions.toString(), 			Toast.LENGTH_SHORT).show();
>        }
>}; // permissionlistener 생성
>
>new TedPermission().with(this)
>                    .setPermissionListener(permissionlistener)
>                    .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
>                            Manifest.permission.READ_EXTERNAL_STORAGE,
>                            Manifest.permission.WRITE_EXTERNAL_STORAGE
>                    ).check(); // 라이브러리를 사용해 permissionlistener 설정
>```
>
>Reference
>
><https://github.com/ParkSangGwon/TedPermission>

 

### Aquery

 Aquery 라이브러리는 Jqeury 문법을 사용하여 코드 작성을 할 수 있게 도와준다. 프로젝트에서는 주로 imageView 를 로딩할 때 사용 한다.

>Get Started
>
>`implementation 'com.github.ar-android:AQuery:1.0.3'`
>
>Using function
>
>`aq.open() & aq.id(R.id.imageView).image(URI).rounded()`
>
>Example
>
>```java 
>private AQuery aq;
>```
>
>```java
>public void transtionIntentUsingAquery(View view) {
>				aq = new AQuery(this);
>
>Intent intent = new Intent(this, OtherClass.class);
>intent.putExtra("id",1); // intent 에 id 값으로 1을 넣어줌
>
>//Intent transition 방향 설정
>//        aq.open(intent);
>//        aq.openFromRight(AqueryPrac.class);
>//        aq.openFromLeft(AqueryPrac.class);
>aq.openFromRight(intent);
>//        aq.openFromLeft(intent);
>
>//        aq.closeToRight();
>//        aq.closeToLeft(); 
>}
>```
>
>```java 
>aq.id(R.id.imageView).image("URI").rounded(); // URI의 이미지를 동그란 모양으로 로딩해줌
>```
>
>Reference
>
><https://github.com/ar-android/AQuery>

Realm Database

realm database 란? 모바일 어플리케이션 내에서 사용하는 최적화된 데이터베이스 플랫폼이다. 

realm database 는 기본적으로 NoSQL을 지향하며 rawSQL 을 사용하지 않아 realm 내부 API를 사용해야한다. 따라서 성능이 올라가긴 하지만 realm database를 사용하기 위해 어느 정도의 학습 시간을 투자 해야한다. 

**Simple Usage**
> build.gradle에 realm library를 불러옴
> ```gradle
> buildscript {
>    repositories {
>        jcenter()
>    }
>    dependencies {
>        classpath "io.realm:realm-gradle-plugin:3.5.0"
>    }
>}
>```
>
> realmObject 기반의 모델을 생성
> ```java
> public class example_model extends RealmObject {
>
>    private String          name;
>    private int             age;
>
>
>    public String getName() { return name; }
>    public void   setName(String name) { this.name = name; }
>    public int    getAge() { return age; }
>    public void   setAge(int age) { this.age = age; }
>}
> ```
>
> realm 객체 생성
> ```java
> // Realm 인스턴스 생성
> realm.executeTransaction(new Realm.Transaction() {
>	@Override
>	public void execute(Realm realm) {
>		User user = realm.createObject(example.class);
>		user.setName("seob");
>		user.setAge("010-xxxx-xxxx");
>	}
> });
> ```
realm 은 나열하기 힘들 정도로 다양한 기능을 제공하므로 realm 공식문서를 참조 하길 바란다.

Realm 공식 문서 [바로가기](https://realm.io/kr/docs/)
