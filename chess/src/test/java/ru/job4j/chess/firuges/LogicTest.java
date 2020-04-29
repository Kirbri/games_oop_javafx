package ru.job4j.chess.firuges;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LogicTest {
    @Test
    public void whenNoMove(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.A1));
        assertThat(logic.move(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void whenMove(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.add(new BishopBlack(Cell.D2));
        assertThat(logic.move(Cell.C1, Cell.G5), is(false));
    }

    @Test(expected = Exception.class)
    public void whenExpected(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.move(Cell.A1, Cell.C1);

    }
}
