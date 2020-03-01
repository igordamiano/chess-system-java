package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

// Torre
public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R"; // R de Rook
	}

	@Override
	public boolean[][] possibleMoves() {
		// todas posicoes falso
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// ACIMA (posição da peça)
		// linha acima e mesma coluna
		p.setValues(position.getRow() -1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() -1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// ESQUERDA
		// mesma linha e vai decrementando a coluna
		p.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// DIREITA
		// mesma linha e vai incrementando a coluna
		p.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		

		// ABAIXO (posição da peça)
		// linha abaixo e mesma coluna
		p.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		
		
		return mat;
	}

}
