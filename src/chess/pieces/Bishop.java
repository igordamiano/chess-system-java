package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

// Bispo
public class Bishop extends ChessPiece{

	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B"; // B de Bishop
	}

	@Override
	public boolean[][] possibleMoves() {
		// todas posicoes falso
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// Noroeste (posi��o da pe�a)
		// diagonal acima e mesma coluna
		p.setValues(position.getRow() -1, position.getColumn() -1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() -1, p.getColumn() -1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// ESQUERDA
		// Nordeste
		p.setValues(position.getRow() -1, position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() -1, p.getColumn() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Sudeste
		// Diagonal baixo direita
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		

		// Sudoeste diagonal baixo esquerda
		p.setValues(position.getRow() + 1, position.getColumn() -1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() -1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		
		
		return mat;
	}

}
