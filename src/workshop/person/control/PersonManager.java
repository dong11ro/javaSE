package workshop.person.control;

import com.sun.security.jgss.GSSUtil;
import workshop.person.entitiy.PersonEntity;
public class PersonManager {
    public PersonManager(){

    }
    public static void main(String[] args) {
        PersonManager pm = new PersonManager();
        PersonEntity[] personArray = new PersonEntity[10];
        pm.fillPersons(personArray);
        pm.printTitleLine();
        pm.printAll(personArray);

        char gender = '여';
        pm.printHowMuchGender(pm.findByGender(personArray, gender), gender);

        String name = "김하늘";
        pm.findPerson(personArray, name);
    }
    public void fillPersons(PersonEntity [] persons){
        persons[0] = new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
        persons[1] = new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
        persons[2] = new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542");
        persons[3] = new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223");
        persons[4] = new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333");
        persons[5] = new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934");
        persons[6] = new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932");
        persons[7] = new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939");
        persons[8] = new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202");
        persons[9] = new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832");
    }
    public void showPerson(PersonEntity person){
        System.out.println("[이름] " + person.getName() + "    [성별] " + person.getGender() + "     [전화번호] " + person.getPhone());
    }
    public void printSlash(){
        System.out.println("---------------------------------------------");
    }
    public void printEqual(){
        System.out.println("=============================================");
    }
    public void printTitleLine(){
        System.out.println("@@@ 인물 정보 조회 시스템 @@@");
        this.printEqual();
    }
    public void printAll(PersonEntity [] persons){
        for (PersonEntity person : persons) {
            this.showPerson(person);
            this.printSlash();
        }
    }
    public int findByGender(PersonEntity [] persons, char gender){
        int cntGender = 0;
        for (PersonEntity person : persons) {
            if (person.getGender() == gender){
                cntGender += 1;
            }
        }
        return cntGender;
    }
    public void printHowMuchGender(int cntGender, char gender){
        System.out.println("성별: '" + gender + "'(은)는 " + cntGender + "명 입니다.");
        this.printEqual();
    }
    public void findPerson(PersonEntity [] persons, String name){
        System.out.println("-- 이름 : '" + name + "'(으)로 찾기 결과입니다. --");
        this.printSlash();

        int targetIdx = 0;
        for (int i = 0; i < persons.length; i++){
            if (persons[i].getName() == name){
                targetIdx = i;
            }
        }

        this.printPerson(persons[targetIdx]);
    }
    public void printPerson(PersonEntity person){
        System.out.println("[이름] " + person.getName());
        System.out.println("[성별] " + person.getGender());
        System.out.println("[전화번호] " + person.getPhone());
        System.out.println("[주소] " + person.getAddress());
    }
}
