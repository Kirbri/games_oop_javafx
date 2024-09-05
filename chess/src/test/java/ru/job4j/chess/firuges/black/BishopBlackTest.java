package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void positionBishopBlackIsC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell actualBishopBlack = bishopBlack.position();
        Cell expected = Cell.C8;
        assertThat(actualBishopBlack).isEqualTo(expected);
    }

    @Test
    void copyBishopBlackIsF8ToA6() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell actualFigureBishopBlack = bishopBlack.copy(Cell.A6).position();
        Cell expected = Cell.A6;
        assertThat(actualFigureBishopBlack).isEqualTo(expected);
    }

    @Test
    void wayBishopBlackIsC1ToG5True() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actualBishopBlack = bishopBlack.way(Cell.G5);
        Cell[] expectedCell = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(actualBishopBlack).isEqualTo(expectedCell);
    }

    @Test
    void wayBishopBlackIsG5ToC1True() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] actualBishopBlack = bishopBlack.way(Cell.C1);
        Cell[] expectedCell = new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(actualBishopBlack).isEqualTo(expectedCell);
    }

    @Test
    void wayBishopBlackIsC7ToC2False() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.C2));
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C7 to C2");
    }
}