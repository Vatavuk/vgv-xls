/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Vedran Grgo Vatavuk
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.vgv.excel.io.cells;

import com.jcabi.immutable.Array;
import com.vgv.excel.io.ECell;
import java.util.Calendar;
import java.util.stream.Collectors;

/**
 * Multiple cells containing Calendar values.
 * @author Vedran Vatavuk (123vgv@gmail.com)
 * @version $Id$
 * @since 0.3
 */
public final class CalendarCells extends AbstractStyleableCells {

    /**
     * Position of cells.
     */
    private final int position;

    /**
     * Array of calendar values.
     */
    private final Array<Calendar> values;

    /**
     * Ctor.
     * @param cvalues Calendar values
     */
    public CalendarCells(final Calendar... cvalues) {
        this(new Array<>(cvalues));
    }

    /**
     * Ctor.
     * @param column Position of cells
     * @param cvalues Values
     */
    public CalendarCells(final int column, final Calendar... cvalues) {
        this(column, new Array<>(cvalues));
    }

    /**
     * Ctor.
     * @param cvalues Values
     */
    public CalendarCells(final Iterable<Calendar> cvalues) {
        this(-1, new Array<>(cvalues));
    }

    /**
     * Ctor.
     * @param column Position of cells
     * @param cvalues Values
     */
    public CalendarCells(final int column, final Iterable<Calendar> cvalues) {
        super();
        this.position = column;
        this.values = new Array<>(cvalues);
    }

    @Override
    public Array<ECell> asArray() {
        return new Array<>(this.values.stream()
            .map(calendar -> new CalendarCell(this.position, calendar))
            .collect(Collectors.toList())
        );
    }
}