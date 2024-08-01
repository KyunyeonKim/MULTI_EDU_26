package com.example.web03board;

import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {
    private List<BoardVO> boardList = new ArrayList<>();

    @Override
    public void create(BoardVO board) {
        boardList.add(board);
        System.out.println("LOG: Created board - " + board);
    }

    @Override
    public BoardVO read(int id) {
        for (BoardVO board : boardList) {
            if (board.getId() == id) {
                System.out.println("LOG: Read board - " + board);
                return board;
            }
        }
        System.out.println("LOG: Board with ID " + id + " not found.");
        return null;
    }

    @Override
    public void update(BoardVO board) {
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getId() == board.getId()) {
                boardList.set(i, board);
                System.out.println("LOG: Updated board - " + board);
                return;
            }
        }
        System.out.println("LOG: Board with ID " + board.getId() + " not found.");
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getId() == id) {
                BoardVO removedBoard = boardList.remove(i);
                System.out.println("LOG: Deleted board - " + removedBoard);
                return;
            }
        }
        System.out.println("LOG: Board with ID " + id + " not found.");
    }
}
