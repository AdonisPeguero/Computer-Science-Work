
abstract class Person7 {
String food;
private String name="unknown";
private String email="none";
public void setName(String name) {this.name=name;}
public String getName(){return name;}
public void setEmail(String email) {this.email=email;}
public abstract void printInfo();
}	
interface living {
void eat(String food);
}
interface working {
void teach(String cource);
}
abstract class Employee7 extends Person7 implements living, working {
private double salary=0;
String course;
public double getSalary() {return salary;}
public void setSalary(double salary) throws SalaryException {
if (salary <0)
throw new SalaryException(super.getName()+"'s salary can't be negative."+" eat:"+ food + "teach:"+ course);
this.salary=salary;
}
public void printInfo(){
System.out.println("Employee: "+super.getName()+ ", email:"+super.getEmail()+ ", salary" + salary);
}
}
class Student7 extends Person7 implements living {
private double age=0;
public double getAge() {return age;}\
public void setAge(double age) throws AgeException {
if (age <0)
throw new AgeException(super.getName()+ "'s age can't be negative."+" eat:" + food);
this.age=age;
}
public void printInfo(){
System.out.println("Student: "+ super.getName()+", Age:"+ age + ",email:" + super.getEmail() + ", eat:"+ food);	
}
public void eat(String food){
this.food=food;	
}
}
class Faculty7 extends Employee7{
String dept="none";
public String getDept() {return dept;}
public void setDept(String dept){
this.dept=dept;	
}
public void printInfo(){
System.out.print("Faculty: "+ super.getName()+", Dept:"+dept + ", email:"+ super.getEmail()+", salary:"+super.getSalary()+" eat:"+ food+ ", teach:"+course);	
}
public void eat(String food){
this.food=food;
}
public void teach(String course){
this.course=course;
}
}
class AgeException extends Exception{
public AgeException(String msg){
	super(msg);
}
}
class SalaryException extends Exception {
public SalaryException(String msg){
super(msg);	
}
}
public class Program7 {
public static void main(String[] args){
try{
double x;
Student7 s1=new Student7();
Student7 s2=new Student7();
Faculty7 f1=new Faculty7();
Faculty7 f2=new Faculty7();
}

try{
s1.setName("peguenoa_s1");
s1.setEmail("peguenoa@kean.edu");
s1.eat("cake");
s1.setAge(-1);
s1.printInfo();
}catch(AgeException e1){
System.out.println(e1);	
}
try {
	s2.setName("peguenoa_s2");
	s2.setEmail("peguenoa@kean.edu");			
	s2.setAge(23);
	s2.eat("cake");
	s2.printInfo();					

} catch (AgeException e1) {
	System.out.println(e1);
}
try {
	f1.setName("peguenoa_f1");				
	f1.setSalary(-1);
	f1.eat("orange");
	f1.teach("CPS2231");
	f1.printInfo();			
}catch (SalaryException e1) {
	System.out.println(e1);
}

try {
	f2.setName("peguenoa_f2");
	f2.setDept("CS");
	f2.setEmail("peguenoa@kean.edu");
	f2.setSalary(10000);
	f2.eat("orange");
	f2.teach("CPS3740");
	f2.printInfo();				
}catch (SalaryException e1) {
	System.out.println(e1);
}
}catch (Exception e3) {
	System.out.println(e3);
}
}