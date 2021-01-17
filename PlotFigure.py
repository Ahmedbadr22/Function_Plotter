# import Require Library's
from matplotlib.backends.backend_qt5agg import FigureCanvasQTAgg as FigureCanvas
from matplotlib.figure import Figure

# Declaring The Plotter Class
class Canvas(FigureCanvas):
    # Constructor
    def __init__(self , parent):
        self.fig = Figure(figsize=(7 , 4 ) , dpi = 100)
        FigureCanvas.__init__(self,self.fig)
        self.setParent(parent)
    # Plot Function to Draw The Graph By Giving It The To List To plot
    def plot(self,x , y):
        self.fig.clear()
        self.ax = self.fig.add_subplot(111)
        self.ax.plot(x,y)
        self.draw()