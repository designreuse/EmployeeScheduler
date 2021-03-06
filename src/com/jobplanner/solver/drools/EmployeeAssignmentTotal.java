/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jobplanner.solver.drools;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jobplanner.contract.Contract;
import com.jobplanner.domain.Employee;
import com.jobplanner.model.ContractModel;

public class EmployeeAssignmentTotal implements Comparable<EmployeeAssignmentTotal>, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
    private int total;

    public EmployeeAssignmentTotal(Employee employee, int total) {
        this.employee = employee;
        this.total = total;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof EmployeeAssignmentTotal) {
            EmployeeAssignmentTotal other = (EmployeeAssignmentTotal) o;
            return new EqualsBuilder()
                    .append(employee, other.employee)
                    .append(total, other.total)
                    .isEquals();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(employee)
                .append(total)
                .toHashCode();
    }

    public int compareTo(EmployeeAssignmentTotal other) {
        return new CompareToBuilder()
                .append(employee, other.employee)
                .append(total, other.total)
                .toComparison();
    }

    @Override
    public String toString() {
        return employee + " = " + total;
    }

    public Contract getEmployeeContract() {
        return employee.getContract();
    }

}
