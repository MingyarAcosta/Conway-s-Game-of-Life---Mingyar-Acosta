package com.mingyaracosta;

import org.junit.Assert;
import org.junit.Test;

public class UniverseTest {

    @Test
    public void testCreateUniverse() {
        Universe universe = new Universe();
        Assert.assertNotNull(universe);
    }

    @Test
    public void testGetDefaultHeightOfUniverse() {
        Universe universe = new Universe();
        Assert.assertEquals(10, universe.getHeight());
    }

    @Test
    public void testGetDefaultWidthOfUniverse() {
        Universe universe = new Universe();
        Assert.assertEquals(10, universe.getWidth());
    }

    @Test
    public void testSettingHeightOfUniverse() {
        Universe universe = new Universe(9, 6);
        Assert.assertEquals(6, universe.getHeight());
    }

    @Test
    public void testSettingWidthOfUniverse() {
        Universe universe = new Universe(9, 6);
        Assert.assertEquals(9, universe.getWidth());
    }

    @Test
    public void testSettingAnAliveCell() {
        Universe universe = new Universe();
        universe.setCell(5, 5, new Cell());
        Assert.assertEquals(new Cell(), universe.getCell(5, 5));
    }

    @Test
    public void testSettingADeadCell() {
        Universe universe = new Universe();
        universe.setCell(5, 5, new Cell(State.DEAD));
        Assert.assertNotEquals(new Cell(), universe.getCell(5, 5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBoundsExceptionOnSetCell() {
        Universe universe = new Universe();
        universe.setCell(5, 50, new Cell(State.DEAD));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBoundsExceptionOnGetCell() {
        Universe universe = new Universe();
        Cell notRetrievableCell = universe.getCell(5, 50);
        Assert.assertEquals(new Cell(), notRetrievableCell);
    }

    @Test
    public void testInitializeAllUniverseWithAliveCells() {
        Universe universe = new Universe();
        universe.initializeCells(State.ALIVE);
        Cell actualCell = universe.getCell(0, 0);
        Assert.assertEquals(new Cell(), actualCell);
    }

    @Test
    public void testInitializeAllUniverseWithDeadCells() {
        Universe universe = new Universe();
        universe.initializeCells(State.DEAD);
        Cell actualCell = universe.getCell(0, 0);
        Assert.assertEquals(new Cell(State.DEAD), actualCell);
    }

    @Test
    public void testCountAliveCellsBaseCase() {
        Universe universe = new Universe(5, 5);
        universe.initializeCells(State.DEAD);
        int aliveCellsCount = universe.getCellsByStateCount(State.ALIVE);
        Assert.assertEquals(0, aliveCellsCount);
    }

    @Test
    public void testCountAliveCellsRegularCase() {
        Universe universe = new Universe(5, 5);
        universe.initializeCells(State.DEAD);
        universe.setCell(1, 1, new Cell());
        universe.setCell(2, 2, new Cell());
        int aliveCellsCount = universe.getCellsByStateCount(State.ALIVE);
        Assert.assertEquals(2, aliveCellsCount);
    }

    @Test
    public void testCountDeadCellsBaseCase() {
        Universe universe = new Universe(5, 5);
        universe.initializeCells(State.DEAD);
        int deadCellsCount = universe.getCellsByStateCount(State.DEAD);
        Assert.assertEquals(25, deadCellsCount);
    }

    @Test
    public void testCountDeadCellsRegularCase() {
        Universe universe = new Universe(5, 6);
        universe.initializeCells(State.DEAD);
        universe.setCell(1, 1, new Cell());
        universe.setCell(2, 2, new Cell());
        int deadCellsCount = universe.getCellsByStateCount(State.DEAD);
        Assert.assertEquals(28, deadCellsCount);
    }

    @Test
    public void testInitialize1RandomAliveCells() {
        Universe universe = new Universe(5, 5);
        universe.initializeNRandomAliveCells(1);
        int aliveCellsCount = universe.getCellsByStateCount(State.ALIVE);
        Assert.assertEquals(1, aliveCellsCount);
    }

    @Test
    public void testInitialize10RandomAliveCells() {
        Universe universe = new Universe(5, 8);
        universe.initializeNRandomAliveCells(10);
        int aliveCellsCount = universe.getCellsByStateCount(State.ALIVE);
        Assert.assertEquals(10, aliveCellsCount);
    }

    @Test
    public void testInitialize15RandomAliveCells() {
        Universe universe = new Universe(7, 3);
        universe.initializeNRandomAliveCells(13);
        int aliveCellsCount = universe.getCellsByStateCount(State.ALIVE);
        Assert.assertEquals(13, aliveCellsCount);
    }

    @Test
    public void testCloneUniverse() {
        Universe originalUniverse = new Universe(7, 3);
        originalUniverse.initializeNRandomAliveCells(13);
        int aliveCellsCountInOriginal = originalUniverse.getCellsByStateCount(State.ALIVE);
        Universe clonedUniverse = originalUniverse.clone();
        int aliveCellsCountInCloned = clonedUniverse.getCellsByStateCount(State.ALIVE);
        Assert.assertEquals(aliveCellsCountInOriginal, aliveCellsCountInCloned);
        Assert.assertNotSame(originalUniverse, clonedUniverse);
    }
}
