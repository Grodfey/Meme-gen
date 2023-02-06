import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;

/*
 * Author Tho Vu
 * CS 2110
 */

/**
 * MemeMagic Graphical User Interface This class contains the graphical user interface for the Meme Magic Software You
 * will need to implement certain portions of this class, marked with comments starting with "TODO" to connect it with
 * your existing code. This class provides an example layout for the GUI. You are encouraged to be creative in your
 * design. More information about Swing is online at:
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 */
public class MemeMagic extends JFrame {

    /**
     * Serialization string required by extending JFrame
     */
    private static final long serialVersionUID = 1L;

    private User user;
    private GraphicalMeme currentMeme;

    private String backgroundImageFilename;

    private BorderLayout panelLayout;
    private JLabel backgroundImageFileNameLabel;
    private JLabel imageDisplayLabel;
    private JPanel controlPanel;
    private JPanel memeViewPanel;
    private JPanel panelPane;
    private JPanel bGTitlePanel;
    private JLabel titleLabel;
    private JTextField titleText;
    private JPanel bGDescriptionPanel;
    private JTextField descriptionText;
    private JLabel descriptionLabel;
    private JPanel memeViewsPanel;
    private JPanel memeCaptionPanel;
    private JLabel memeCaptionLabel;
    private JTextField memeCaptionText;
    private JPanel memeComboBox;
    private JLabel verticalAlignLabel;
    private JComboBox alignmentChoice;

    public MemeMagic() {
        this.user = new User();
    }

    public MemeMagic(User user) {
        this.user = user;
    }

    /**
     * Main method. This method initializes a PhotoViewer, loads images into a PhotographContainer, then initializes the
     * Graphical User Interface.
     * 
     * @param args Optional command-line arguments
     */
    public static void main(String[] args) {

        // Create a User object for this instance of Meme Magic
        User user = new User();

        // Instantiate the PhotoViewer Class
        MemeMagic myViewer = new MemeMagic(user);

        // Invoke and start the Graphical User Interface
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.initialize());
    }

    /**
     * Initialize all the GUI components. This method will be called by SwingUtilities when the application is started.
     */
    private void initialize() {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tell Java to title the window to Meme Magic
        this.setTitle("Meme Magic");

        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);

        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();
        imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        imageDisplayLabel.setPreferredSize(new Dimension(550, 550));

        // Create a panel on which to display the full image
        memeViewPanel = new JPanel(new BorderLayout());
        memeViewPanel.setPreferredSize(new Dimension(550, 550));
        memeViewPanel.add(imageDisplayLabel, BorderLayout.CENTER);

        // Create a panel on which to display the controls for building a Meme
        controlPanel = new JPanel(new BorderLayout());

        // Create a panel that holds BackgroundImage information and give it a title
        JPanel backgroundImagePanel = new JPanel(new BorderLayout());
        backgroundImagePanel.setBorder(BorderFactory.createTitledBorder("Background Image"));

        // Create a panel that provides input for the BackgroundImage fileName
        JPanel backgroundImageFilePanel = new JPanel();

        // Label
        JLabel backgroundImageFileLabel = new JLabel("Filename: ");
        backgroundImageFileLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageFilePanel.add(backgroundImageFileLabel);

        // Button
        JButton backgroundImageButton = new JButton("Browse");
        backgroundImageFilePanel.add(backgroundImageButton);
        backgroundImageButton.setPreferredSize(new Dimension(85, 20));

        // TODO The button needs a listener
        backgroundImageButton.addActionListener(new OpenButtonListener());

        // Label that will contain the filename of the image
        backgroundImageFileNameLabel = new JLabel("<choose>");
        backgroundImageFilePanel.add(backgroundImageFileNameLabel);
        backgroundImageFileNameLabel.setPreferredSize(new Dimension(265, 20));

        // Add the panel about the BackgroundImage fileName to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageFilePanel, BorderLayout.NORTH);

        // TODO Complete the Control Panel implementation (with Background Image and Meme panels)

        // JLabel and JTextField Title
        bGTitlePanel = new JPanel();
        titleLabel = new JLabel("Title: ");
        titleLabel.setPreferredSize(new Dimension(100, 20));
        bGTitlePanel.add(titleLabel);

        titleText = new JTextField(30);
        bGTitlePanel.add(titleText);

        // JLabel and JTextField Description
        bGDescriptionPanel = new JPanel();
        descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setPreferredSize(new Dimension(100, 20));
        bGDescriptionPanel.add(descriptionLabel);

        descriptionText = new JTextField(30);
        bGDescriptionPanel.add(descriptionText);

        // Adds both bGTitlePanel and bGDescriptionPanel to backgroundImagePanel
        backgroundImagePanel.add(bGTitlePanel);
        backgroundImagePanel.add(bGDescriptionPanel, BorderLayout.SOUTH);

        // New meme JPanel
        memeViewsPanel = new JPanel(new BorderLayout());
        memeViewsPanel.setBorder(BorderFactory.createTitledBorder("Meme"));

        // Meme Caption JPanel
        memeCaptionPanel = new JPanel();

        // Meme Caption Label and TextField
        memeCaptionLabel = new JLabel("Caption ");
        memeCaptionLabel.setPreferredSize(new Dimension(100, 20));
        memeCaptionPanel.add(memeCaptionLabel);

        memeCaptionText = new JTextField(30);
        memeCaptionPanel.add(memeCaptionText);

        // Meme ComboBox
        memeComboBox = new JPanel();
        verticalAlignLabel = new JLabel("Vertical Align: ");
        verticalAlignLabel.setPreferredSize(new Dimension(80, 20));
        memeComboBox.add(verticalAlignLabel);

        String choiceTop = "top";
        String choiceMiddle = "middle";
        String choiceBottom = "bottom";
        String[] choices = new String[3];
        choices[0] = choiceTop;
        choices[1] = choiceMiddle;
        choices[2] = choiceBottom;
        alignmentChoice = new JComboBox(choices);
        alignmentChoice.setPreferredSize(new Dimension(375, 20));
        memeComboBox.add(alignmentChoice);

        // Adds caption JPanel and meme ComboBox to memeViewPanel
        memeViewsPanel.add(memeCaptionPanel, BorderLayout.NORTH);
        memeViewsPanel.add(memeComboBox);

        // Add generate/save button
        JPanel generateAndSave = new JPanel();

        JButton generateB = new JButton("Generate");
        generateB.setActionCommand("generate");
        generateAndSave.add(generateB);
        generateB.setPreferredSize(new Dimension(85, 20));
        GenerateButtonListener generateButtonListener = new GenerateButtonListener();
        generateB.addActionListener(generateButtonListener);

        JButton saveB = new JButton("Save");
        saveB.setActionCommand("save");
        generateAndSave.add(saveB);
        SaveButtonListener saveButtonListener = new SaveButtonListener();
        saveB.addActionListener(saveButtonListener);
        saveB.setPreferredSize(new Dimension(85, 20));

        // Add the BackgroundImage information panel to the control panel
        controlPanel.add(backgroundImagePanel, BorderLayout.NORTH);
        controlPanel.add(memeViewsPanel);
        controlPanel.add(generateAndSave, BorderLayout.SOUTH);

        // Add all the panels to the main display based on BorderLayout
        controlPanel.setPreferredSize(new Dimension(500, 570));
        panelPane.add(controlPanel, BorderLayout.WEST);
        panelPane.add(memeViewPanel, BorderLayout.CENTER);

        // Add the panelPane to the contentPane of the Frame (Window)
        this.getContentPane().add(panelPane);

        // Set the preferred size and show the main application window
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);

    }

    private class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("generate")) {

                String title = titleText.getText();
                String description = descriptionText.getText();
                String text = memeCaptionText.getText();
                String verticalAlingment = "" + alignmentChoice.getItemAt(alignmentChoice.getSelectedIndex());

                BackgroundImage bgImage1 = new BackgroundImage(backgroundImageFilename, title, description);
                currentMeme = new GraphicalMeme(bgImage1, text, user);
                currentMeme.setCaptionVerticalAlign(verticalAlingment);

                try {
                    BufferedImage bImage = currentMeme.compileMeme();
                    imageDisplayLabel = new JLabel(new ImageIcon(bImage));
                    memeViewPanel.add(imageDisplayLabel);
                    memeViewPanel.repaint();
                }

                catch (Exception e1) {
                    System.out.println("Select a File");
                }

            }
        }
    }

    /**
     * ActionListener for the open button. When the button is pressed, this ActionListener opens a FileChooser, asks the
     * user to choose a JPG image file, then sets the field backgroundImageFilename in the main class.
     */
    private class OpenButtonListener implements ActionListener {
        /**
         * Action performed operation. Opens a save FileChooser, asks the user to choose a JPG image file, then sets the field
         * backgroundImageFilename in the main class.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Choose a Background Image");
            chooser2.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
            int returnVal = chooser2.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                backgroundImageFilename = chooser2.getSelectedFile().getAbsolutePath();
                backgroundImageFileNameLabel.setText(backgroundImageFilename);
            }

        }
    }

    /**
     * ActionListener for the save button. When the button is pressed, this ActionListener opens a save FileChooser, asks
     * the user to choose a location and filename, then writes the graphical meme data to a PNG image file.
     */
    private class SaveButtonListener implements ActionListener {
        /**
         * Action performed operation. Opens a save FileChooser, asks the user to choose a location and filename, then writes
         * the graphical meme data to a PNG file.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Save Meme");
            chooser2.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            int returnVal = chooser2.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String destinationFile = chooser2.getSelectedFile().getAbsolutePath();

                // TODO: Writing an image throws a checked exception that must be handled.
                // Catch the exceptions and provide the user with an appropriate message
                // ImageIO.write(currentMeme.compileMeme(), "png", new File(destinationFile));
                try {
                    ImageIO.write(currentMeme.compileMeme(), "png", new File(destinationFile));
                } catch (Exception e) {
                    System.out.println("Create a meme first to save");
                }
            }

        }
    }
}
