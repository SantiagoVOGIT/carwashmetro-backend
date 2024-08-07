from datetime import datetime
from typing import Dict, Any

from src.domain.entities.employee.value_objects.EmployeeId import EmployeeId
from src.domain.entities.employee.value_objects.EmployeePosition import EmployeePosition
from src.domain.entities.employee.value_objects.EmployeeStatus import EmployeeStatus
from src.domain.entities.user.value_objects.UserId import UserId


class Employee:
    __id: EmployeeId
    __userId: UserId
    __position: EmployeePosition
    __status: EmployeeStatus
    __salary: float
    __createdAt: datetime

    def __init__(self,
                 id: EmployeeId,
                 userId: UserId,
                 position: EmployeePosition,
                 status: EmployeeStatus,
                 salary: float,
                 createdAt: datetime):
        self.__id = id
        self.__userId = userId
        self.__position = position
        self.__status = status
        self.__salary = salary
        self.__createdAt = createdAt

    def getId(self) -> EmployeeId:
        return self.__id

    def getUserId(self) -> UserId:
        return self.__userId

    def getPosition(self) -> EmployeePosition:
        return self.__position

    def getStatus(self) -> EmployeeStatus:
        return self.__status

    def getSalary(self) -> float:
        return self.__salary

    def getCreatedAt(self) -> datetime:
        return self.__createdAt

    @staticmethod
    def toDict(employee: 'Employee') -> Dict[str, Any]:
        return {
            "id": employee.getId().getValue(),
            "userId": employee.getUserId().getValue(),
            "position": employee.getPosition().value,
            "status": employee.getStatus().value,
            "salary": employee.getSalary(),
            "createdAt": employee.getCreatedAt().isoformat()
        }
