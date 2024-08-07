from abc import ABC, abstractmethod
from typing import TypeVar

from src.domain.entities.cell.Cell import Cell
from src.domain.entities.cell.value_objects.CellId import CellId
from src.domain.entities.cell.value_objects.CellStatus import CellStatus
from src.domain.entities.cell.value_objects.SpaceNumber import SpaceNumber
from src.domain.entities.vehicle.value_objects.VehicleType import VehicleType

T = TypeVar('T')


class CellGateway(ABC):

    @abstractmethod
    def createCell(self,
                   spaceNumber: SpaceNumber,
                   vehicleType: VehicleType,
                   status: CellStatus
                   ) -> Cell:
        pass

    @abstractmethod
    def updateCell(self,
                   cellId: CellId,
                   spaceNumber: SpaceNumber,
                   vehicleType: VehicleType,
                   status: CellStatus
                   ) -> Cell:
        pass
