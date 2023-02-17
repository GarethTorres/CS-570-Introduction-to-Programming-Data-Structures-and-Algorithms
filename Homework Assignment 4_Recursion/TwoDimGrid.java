/*
 * Guizhi Xu
 * CWID: 20008770
 * */

package Maze;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridLayout;

/**
 * TwoDimGrid is a two dimensional array of buttons. Each button can be toggled
 * between two colors by
 * clicking it with the mouse, or its color can be changed/queried under program
 * control.
 **/

public class TwoDimGrid extends JPanel implements GridColors {

    // Data Fields
    /** Prefered button size */
    private static final int PREFERED_BUTTON_SIZE = 60;
    /** Default number of rows */
    private static final int DEFAULT_COLS = 20;
    /** Default number of columns */
    private static final int DEFAULT_ROWS = 20;
    /** A two dimensional grid of buttons */
    private JButton[][] theGrid;
    /** Number of rows */
    private int nRows;
    /** Number of columns */
    private int nCols;

    // Constructors
    /**
     * Construct a TwoDimGrid of the specified size and of the specified colors
     */
    public TwoDimGrid(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        setPreferredSize(new Dimension(nCols * PREFERED_BUTTON_SIZE,
                nRows * PREFERED_BUTTON_SIZE));
        setLayout(new GridLayout(nRows, nCols));
        theGrid = new JButton[nCols][];
        for (int i = 0; i != nCols; ++i) {
            theGrid[i] = new JButton[nRows];
            for (int j = 0; j != nRows; ++j) {
                theGrid[i][j] = new JButton(i + ", " + j);
                theGrid[i][j].setOpaque(true);
                theGrid[i][j].setBackground(BACKGROUND);
                theGrid[i][j].addActionListener(new ToggleColor(theGrid[i][j]));
            }
        }

        // Add the buttons to the button panel
        for (int j = 0; j != nRows; ++j) {
            for (int i = 0; i != nCols; ++i) {
                add(theGrid[i][j]);
            }
        }
    }

    // Accessors and Mutators and Get the number of columns //

    public int getNCols() {
        return nCols;
    }

    // Get the number of rows //

    public int getNRows() {
        return nRows;
    }

    // Get the color at a given coordinate //

    public Color getColor(int x, int y) {
        return theGrid[x][y].getBackground();
    }

    // Change the color at a given coordinate //
    public void recolor(int x, int y, Color newColor) {
        theGrid[x][y].setBackground(newColor);
        repaint();
    }

    // Set the color of each square in the grid that correspond to the elements of
    // the given array with the value 1//

    public void recolor(char[][] bitMap, Color aColor) {
        for (int i = 0; i != bitMap.length; ++i) {
            for (int j = 0; j != bitMap[i].length; ++j) {
                if (bitMap[i][j] == '1') {
                    theGrid[j][i].setBackground(aColor);
                }
            }
        }
    }

    // <exercise chapter="5" section="5" type="programming" number="2"> //
    // Recolor all cells that are a given tempColor //
    public void recolor(Color tempColor, Color newColor) {
        for (int i = 0; i != getNCols(); ++i) {
            for (int j = 0; j != getNRows(); ++j) {
                if (theGrid[i][j].getBackground().equals(tempColor)) {
                    theGrid[i][j].setBackground(newColor);
                }
            }
        }
        repaint();
    }
    /* </exercise> */

    // Inner class
    /** ActionListener class to toggle color when clicked */
    private class ToggleColor
            implements ActionListener {
        // DataField

        /** The button to be responded to */
        private JButton me;

        // Constructor
        // Construct ToggleColor object for a given button to be responded to //

        public ToggleColor(JButton theButton) {
            me = theButton;
        }

        // Action in response to button push //

        public void actionPerformed(ActionEvent e) {
            if (me.getBackground().equals(BACKGROUND)) {
                me.setBackground(NON_BACKGROUND);
            } else {
                me.setBackground(BACKGROUND);
            }
        }
    }
}
