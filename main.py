'''
This App Writen By Ahmed Badr
'''
import sys
from PySide2.QtWidgets import QApplication , QWidget , QLineEdit , QLabel , QMessageBox , QPushButton
from PlotFigure import Canvas
import numpy as np
from PySide2.QtGui import QIcon ,QFont

class MainWindow(QWidget):
    # Declare A Constructor And Give Attributes To Our Form
    def __init__(self):
        super().__init__()
        icon = QIcon('icon.jpg')
        self.setWindowIcon(icon)
        self.setWindowTitle('Function Plotter')
        self.setGeometry(700,700,1200,405)
        self.getui()
        self.setMaximumWidth(1200)
        self.setMaximumHeight(405)
        self.setMinimumWidth(1200)
        self.setMinimumHeight(405)

    def getui(self):
        # Declare Our Graph Plotter
        self.canves = Canvas(self)
        self.canves.move(0,0)

        # Declare
        self.equationInput = QLineEdit(self)
        self.equationInput.setToolTip("Enter Equation in Tearm of X , The Allowed Operators is + - * / ^ Only!")
        self.equationInput.setGeometry(900,90,250,30)

        self.equlable = QLabel('Enter Equation:F(x) =', self)
        self.equlable.move(775, 95)

        self.logoicon = QIcon('icon.jpg')
        pixmap = self.logoicon.pixmap(100 , 100 , QIcon.Active , QIcon.On )

        self.helloMessage = QLabel("Let's Plot Nice Graphs :)" ,self)
        self.helloMessage.move(180,150)
        self.helloMessage.setFont(QFont('Arial' , 22))

        self.logolable = QLabel('', self)
        self.logolable.move(50, 120)
        self.logolable.setPixmap(pixmap)

        self.maxXInput = QLineEdit(self)
        self.maxXInput.setToolTip("Enter The Maximum value of X")
        self.maxXInput.setGeometry(900, 130, 100, 30)

        self.maxlable = QLabel('Enter Max X Value : ', self)
        self.maxlable.move(775, 134)

        self.minXInput = QLineEdit(self)
        self.minXInput.setToolTip("Enter The Minimum value of X")
        self.minXInput.setGeometry(900, 170, 100, 30)

        self.minlable = QLabel('Enter Min X Value : ', self)
        self.minlable.move(775, 175)

        self.button = QPushButton('Plot' , self)
        self.button.move(900,220)
        self.button.clicked.connect(self.getData)
    # getData Function I a function That Happen When User Press in The Plot Button , It Get The Data And Check it's Validation
    def getData(self):
        Max_value_txt = self.maxXInput.text()
        Min_value_txt = self.minXInput.text()
        f = self.equationInput.text()

        if self.equationInput.text() :
            if self.maxXInput.text() and self.minXInput.text():
                max = int(Max_value_txt)
                min = int(Min_value_txt)

                if min > max:
                    QMessageBox.question(self, 'Validation!',
                                         'The Min Value is Bigger Than The Max Value Input, Please Replace it!',
                                         QMessageBox.Yes)
                else:
                    self.helloMessage.hide()
                    self.logolable.hide()
                    x = np.linspace(min, max, 100)
                    f = f.replace('^', '**')
                    y = eval(f)
                    self.canves.plot(x, y)
            else:
                QMessageBox.question(self, 'Validation!', 'Please Enter Missing X Value!', QMessageBox.Ok)
        else:
            QMessageBox.question(self, 'Validation!', 'Please Enter Equation!', QMessageBox.Ok)


myapp = QApplication(sys.argv)
window = MainWindow()
window.show()
myapp.exec_()
myapp.exit(0)
