package programs;


import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramSalary {
     public static void main(String[] args) throws ParseException//indica que o metodo pode usar esse tipo de exceção
      {
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//isso serve para fazer a conversão do modo ISO para o brasileiro personalizado
          Locale.setDefault(Locale.US);
          Scanner sc = new Scanner(System.in);

          System.out.print("Enter department's name: ");
          String departmentName = sc.nextLine();
          System.out.println("Enter worker data: ");
          System.out.print("Name: ");
          String workerName = sc.nextLine();
          System.out.print("Level: ");
          String workerLevel = sc.nextLine();
          System.out.print("Base salary: ");
          double baseSalary = sc.nextDouble();
          Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
          //o WorkerLevel.valueOf(workerLevel) faz a conversão do tipo enumerado para a forma de string da classe
          //instancia outro objeto (Department) na classe e instancia a variavel departmentName para o objeto


          System.out.print("How many contracts to this worker? ");
          int n = sc.nextInt();

          for (int i = 1; i <= n; i++) {
               System.out.println("Enter contract #" + i + "data: ");
               System.out.print("Date (DD/MM/YYYY): ");
               Date contractDate = sdf.parse(sc.next());
               System.out.print("Value per hour: ");
               double valuePerHour = sc.nextDouble();
               System.out.print("Duration (hours): ");
               int hours = sc.nextInt();
               HourContract contract = new HourContract(contractDate, valuePerHour, hours);
               worker.addContract(contract);//associa o contrato com o worker

          }
          System.out.println();
          System.out.print("Enter month and year to calculate income  (MM/YYYY): ");
          String monthAndYear = sc.next();
          int month = Integer.parseInt(monthAndYear.substring(0,2));//lê os 2 primeiros caracteres
          int year = Integer.parseInt(monthAndYear.substring(3));//lê dos 3 para a frente
          System.out.println("Name " + worker.getName());
          System.out.println("Department:  "+ worker.getDepartment().getName());//o getDepartment() serve para acessar o outro objeto associado ao worker, e depois pega o nome
          System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));//o string format faz a impressão com duas casas decimais
          sc.close();
     }
}
