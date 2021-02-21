package com.gs.algorithms.dp.allpath;

public class Cell {
  
  int row;
  int col;

  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + col;
    result = prime * result + row;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    System.out.println("checkimg.. " + (Cell)obj);
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cell other = (Cell) obj;
    if (col != other.col)
      return false;
    if (row != other.row)
      return false;
    return true;
  }

  public Cell nextCell(Cell direction) {
    int nextRow = this.row + direction.row;
    int nextCol = this.col + direction.col;
    return new Cell(nextRow, nextCol);
  }

  public String toString() {
    return "(" + row + ", " + col + ")";
  }

}
