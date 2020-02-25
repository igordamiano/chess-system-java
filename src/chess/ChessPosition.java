package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;

	public ChessPosition(char column, int row) {

		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro instanciando ChessPosition. Valores válidos são a1 até h8");
		}

		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
		
		/*
		 * achar a linha(row) no tabuleiro
		 * Para achar a linha 8 no tabuleiro: linha 8 - 8 = 0 -> Então a linha 8 no tabuleiro é a 0 na matriz
		 * Para achar a linha 7 no tabuleiro: linha 8 - 7 = 1 -> Então a linha 7 no tabuleiro é a 1 na matriz
		 * ...... matriz_row = 8 - chess_row
		 * ......
		 * Achar a coluna no tabuleiro
		 * Coluna A corresponde a coluna 0 na matriz
		 * coluna B=1
		 * unicode do 'a' - unicode 'a' = 0
		 * 'b' - 'a' = 1
		 * 'c' - 'a' = 2
		 * ......
		 * matrix_column = chess_column - 'a'
		 */
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	

}
