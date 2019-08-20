package com.mingyaracosta;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

    @Test
    public void testIfCellIsAlive() {
        Cell cell = new Cell();
        Assert.assertEquals(State.ALIVE, cell.getState());
    }

    @Test
    public void testIfCellIsDead() {
        Cell cell = new Cell();
        cell.setState(State.DEAD);
        Assert.assertEquals(State.DEAD, cell.getState());
    }

    @Test
    public void testIfCellIsCreatedDead() {
        Cell cell = new Cell(State.DEAD);
        Assert.assertEquals(State.DEAD, cell.getState());
    }

    @Test
    public void testIfCellIsCreatedAlive() {
        Cell cell = new Cell(State.ALIVE);
        Assert.assertEquals(State.ALIVE, cell.getState());
    }
}
