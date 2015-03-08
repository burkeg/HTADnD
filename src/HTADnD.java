import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.*;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Table;
//import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.swt.widgets.List;


public class HTADnD 
{

	protected Shell shlDndGeneratorV;
	private Text numPlayer;
	private Text avgPlayerLvl;
	private Text chaptCount;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
			HTADnD window = new HTADnD();
			window.open();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() 
	{
		Display display = Display.getDefault();
		createContents();
		shlDndGeneratorV.open();
		shlDndGeneratorV.layout();
		while (!shlDndGeneratorV.isDisposed()) 
		{
			if (!display.readAndDispatch()) 
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() 
	{
		//display = new Display();
		shlDndGeneratorV = new Shell();
		shlDndGeneratorV.setSize(782, 516);
		shlDndGeneratorV.setText("DnD Generator V.6");
		shlDndGeneratorV.setLayout(null);
		
		Label lblPlayerCount = new Label(shlDndGeneratorV, SWT.NONE);
		lblPlayerCount.setBounds(10, 10, 120, 15);
		lblPlayerCount.setText("Player Count");
		
		Label lblPlayerAverageLevel = new Label(shlDndGeneratorV, SWT.NONE);
		lblPlayerAverageLevel.setBounds(10, 58, 120, 15);
		lblPlayerAverageLevel.setText("Player Average Level");
		
		Label lblChapterCount = new Label(shlDndGeneratorV, SWT.NONE);
		lblChapterCount.setBounds(10, 104, 120, 15);
		lblChapterCount.setText("Chapter Count");
		
		final List EnemiesList = new List(shlDndGeneratorV, SWT.BORDER);
		EnemiesList.setBounds(10, 322, 120, 121);
		formToolkit.adapt(EnemiesList, true, true);
		
		final List BossesList = new List(shlDndGeneratorV, SWT.BORDER);
		BossesList.setBounds(10, 174, 120, 121);
		formToolkit.adapt(BossesList, true, true);
		
		final List ChaptersList = new List(shlDndGeneratorV, SWT.BORDER);
		ChaptersList.setBounds(136, 128, 207, 314);
		formToolkit.adapt(ChaptersList, true, true);
		
		numPlayer = new Text(shlDndGeneratorV, SWT.BORDER);
		numPlayer.setBounds(10, 31, 76, 21);
		numPlayer.setToolTipText("Type the number of players in your game here");
		numPlayer.setText("###");
		
		avgPlayerLvl = new Text(shlDndGeneratorV, SWT.BORDER);
		avgPlayerLvl.setBounds(10, 79, 76, 21);
		avgPlayerLvl.setToolTipText("Type the average level of YOUR game's characters here");
		avgPlayerLvl.setText("###");
		
		chaptCount = new Text(shlDndGeneratorV, SWT.BORDER);
		chaptCount.setBounds(10, 125, 76, 21);
		chaptCount.setToolTipText("Type the number of chapters you want generated here");
		chaptCount.setText("1");
		
		Button clearBtn = new Button(shlDndGeneratorV, SWT.NONE);
		clearBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				try
				{
					numPlayer.setText("###");
					avgPlayerLvl.setText("###");
					chaptCount.setText("1");
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
					return;
				}
				try
				{
					EnemiesList.removeAll();
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
					return;
				}
				try
				{
					BossesList.removeAll();
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
					return;
				}
				try
				{
					ChaptersList.removeAll();
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
					return;
				}
			}
		});
		clearBtn.setBounds(351, 448, 75, 25);
		clearBtn.setToolTipText("Clear ALL");
		clearBtn.setText("Clear");
		
		Button addChapters = new Button(shlDndGeneratorV, SWT.NONE);
		addChapters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				int chapters, playLvlAvg, playerNum;
				try 
				{
					chapters = Integer.parseInt(chaptCount.getText());
				}
				catch (Exception exc)
				{
					MessageDialog.openError(shlDndGeneratorV, "Entry Error", "Invalid Chapter Count (Wrong Type)");
					return;
				}
				try
				{
					playLvlAvg = Integer.parseInt(avgPlayerLvl.getText());
				}
				catch (Exception exc)
				{
					MessageDialog.openError(shlDndGeneratorV, "Entry Error", "Invalid Average Player level (Wrong Type)");
					return;
				}
				try
				{
					playerNum = Integer.parseInt(numPlayer.getText());
				}
				catch (Exception exc)
				{
					MessageDialog.openError(shlDndGeneratorV, "Entry Error", "Invalid number of players (Wrong Type)");
					return;
				}
			}
		});
		addChapters.setBounds(186, 448, 157, 25);
		addChapters.setToolTipText("Generate Selected things");
		addChapters.setText("Add Chapter(s)");
		
		Button checkGenEnemies = new Button(shlDndGeneratorV, SWT.CHECK);
		checkGenEnemies.setBounds(156, 33, 195, 16);
		checkGenEnemies.setSelection(true);
		checkGenEnemies.setToolTipText("select this check box if you would like enemies to be generated");
		checkGenEnemies.setText("Generate Enemies and Bosses");
		
		Button checkGenMap = new Button(shlDndGeneratorV, SWT.CHECK);
		checkGenMap.setBounds(156, 57, 93, 16);
		checkGenMap.setSelection(true);
		checkGenMap.setToolTipText("Select this check box if you would like a map to be generated");
		checkGenMap.setText("Generate Map");
		
		Button checkGenQuest = new Button(shlDndGeneratorV, SWT.CHECK);
		checkGenQuest.setBounds(156, 81, 143, 16);
		checkGenQuest.setSelection(true);
		checkGenQuest.setToolTipText("Select this checkbox if you would like a quest to be generated");
		checkGenQuest.setText("Generate Quest Line");
		
		Label lblChapters = new Label(shlDndGeneratorV, SWT.NONE);
		lblChapters.setBounds(136, 104, 55, 15);
		formToolkit.adapt(lblChapters, true, true);
		lblChapters.setText("Chapters");
		
		Label Enemieslbl = formToolkit.createLabel(shlDndGeneratorV, "Enemies", SWT.NONE);
		Enemieslbl.setBounds(10, 156, 120, 15);
		
		Canvas MapViewer = new Canvas(shlDndGeneratorV, SWT.NONE);
		//Device device = new Device();
		Image image = new Image(display, "C:/Users/Jackson/Documents/GitHub/HTADnDUI/terrain.png"); 
		MapViewer.setBounds(357, 21, 399, 415);
		formToolkit.adapt(MapViewer);
		formToolkit.paintBordersFor(MapViewer);
		
		GC gc = new GC(image); 
		MapViewer.setBackgroundImage(image);
		
		Label lblMapalsoAvailible = new Label(shlDndGeneratorV, SWT.NONE);
		lblMapalsoAvailible.setBounds(360, 0, 332, 15);
		formToolkit.adapt(lblMapalsoAvailible, true, true);
		lblMapalsoAvailible.setText("Map: (also availible as a PNG image)");
		
		ImageHyperlink imageLink = formToolkit.createImageHyperlink(shlDndGeneratorV, SWT.NONE);
		imageLink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent arg0) {
			}
			public void linkEntered(HyperlinkEvent arg0) {
			}
			public void linkExited(HyperlinkEvent arg0) {
			}
		});
		imageLink.setBounds(641, 448, 115, 19);
		formToolkit.paintBordersFor(imageLink);
		imageLink.setText("Map");
		
		Button btnGenerateMap = new Button(shlDndGeneratorV, SWT.NONE);
		btnGenerateMap.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
			}
		});
		btnGenerateMap.setBounds(499, 448, 101, 25);
		formToolkit.adapt(btnGenerateMap, true, true);
		btnGenerateMap.setText("Generate Map");
		
		Label lblBosses = new Label(shlDndGeneratorV, SWT.NONE);
		lblBosses.setBounds(10, 301, 55, 15);
		formToolkit.adapt(lblBosses, true, true);
		lblBosses.setText("Bosses");
		


	}
}