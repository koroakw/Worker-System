package entities;

import entities_enum.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double basealary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double basealary, Department department) {
        this.name = name;
        this.level = level;
        this.basealary = basealary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBasealary() {
        return basealary;
    }

    public void setBasealary(Double basealary) {
        this.basealary = basealary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {// o set contracts foi removido pois a lista é trocada, e recebe outra lista
        return contracts;
    }


    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month) {
        double sum = basealary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());//pra cada contrado c, será setado neste calendario a data do contrato c
            //o get date pega a data do contrato e define a data como sendo a data do calendario
            int c_year = cal.get(Calendar.YEAR);//pega o ano da data
            int c_month = 1 + cal.get(Calendar.MONTH);//pega o mês da data, e acrescenta +1 pois o mês no calendar começa com 0

            if (year == c_year && month == c_month) {//se o ano informado como argumento foi igual ao ano deste contrato
                //e se o mês informado como parametro for igual ao mês desse contrato:

                sum += c.totalValue();//o valor dele entra na soma
            }

        } return sum;
    }
}

