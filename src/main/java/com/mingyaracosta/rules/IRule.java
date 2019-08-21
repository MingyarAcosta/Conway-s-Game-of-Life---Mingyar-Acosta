package com.mingyaracosta.rules;

import com.mingyaracosta.Cell;

public interface IRule {

    Cell evaluate(Cell currentCell, int aliveNeighborsCount);

    IRule nextRule();
}
