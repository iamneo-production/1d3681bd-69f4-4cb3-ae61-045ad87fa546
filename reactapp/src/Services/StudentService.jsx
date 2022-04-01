import axios from 'axios';

const studenturl = "http://localhost:8080/UserModel";

class StudentService {

    getEmployees(){
        return axios.get(studenturl);
    }

    createEmployee(employee){
        return axios.post(studenturl, employee);
    }

    getEmployeeById(employeeId){
        return axios.get(studenturl + '/' + employeeId);
    }

    updateEmployee(employee, employeeId){
        return axios.put(studenturl + '/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(studenturl + '/' + employeeId);
    }
}

export default new StudentService()