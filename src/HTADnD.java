import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Table;
// not sure what this is for, but it doesn't work: import org.eclipse.wb.swt.SWTResourceManager;


public class HTADnD 
{

	protected Shell shlDndGeneratorV;
	private Text numPlayer;
	private Text avgPlayerLvl;
	private Text chaptCount;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table chaptOutTable;
	private Text enemiesAndBossesOut;

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
		shlDndGeneratorV = new Shell();
		shlDndGeneratorV.setSize(450, 516);
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
		clearBtn.setBounds(349, 442, 75, 25);
		clearBtn.setToolTipText("Clear ALL");
		clearBtn.setText("Clear");
		
		Button addChapters = new Button(shlDndGeneratorV, SWT.NONE);
		addChapters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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
		addChapters.setBounds(186, 442, 157, 25);
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
		
		chaptOutTable = formToolkit.createTable(shlDndGeneratorV, SWT.NONE);
		chaptOutTable.setBounds(136, 125, 288, 311);
		chaptOutTable.setEnabled(false);
		chaptOutTable.setToolTipText("This is where chapters will be output to");
		formToolkit.paintBordersFor(chaptOutTable);
		chaptOutTable.setHeaderVisible(true);
		chaptOutTable.setLinesVisible(true);
		
		enemiesAndBossesOut = formToolkit.createText(shlDndGeneratorV, "New Text", SWT.NONE);
		enemiesAndBossesOut.setBounds(10, 177, 120, 259);
		enemiesAndBossesOut.setToolTipText("This is where enemies and bosses will be output to");
		enemiesAndBossesOut.setEditable(false);
		
		Label lblChapters = new Label(shlDndGeneratorV, SWT.NONE);
		lblChapters.setBounds(136, 104, 55, 15);
		formToolkit.adapt(lblChapters, true, true);
		lblChapters.setText("Chapters");
		
		Label lblEnemiesAndBosses = formToolkit.createLabel(shlDndGeneratorV, "Enemies and Bosses", SWT.NONE);
		lblEnemiesAndBosses.setBounds(10, 152, 120, 15);

	}
}
