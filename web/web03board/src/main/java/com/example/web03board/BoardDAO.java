package com.example.web03board;

public interface BoardDAO {
    void create(BoardVO board);
    BoardVO read(int id);
    void update(BoardVO board);
    void delete(int id);
}
