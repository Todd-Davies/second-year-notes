"""
PLEASE DO NOT JUDGE ME ON THE CONTENTS OF THIS FILE
IT IS THE DEFINITION OF A QUICK HACK ;)
"""


from string import Template
from os import listdir

s = Template("""
\card{
  \\textbf{$question}\\\\\\vspace{1em}
  \\begin{tabularx}{0.8\\textwidth}{lX}
    $answer1
    $answer2
    $answer3
    $answer4
  \end{tabularx}
}{
  \\begin{tabularx}{0.8\\textwidth}{lX}
    $actual1
    $actual2
    $actual3
    $actual4
  \end{tabularx}
}
""")

def convert(question):
  lines = question.split('\n')
  for i in range(1,9):
    out = ""
    if lines[i]:
      num = (i % 4)
      if num == 0:
        num = 4
      out = str(num) + ". & " + lines[i]
      if i % 4 != 0:
        out = out + "\\\\"  
    else:
      out = " & " 
      if i % 4 != 0:
        out = out + "\\\\"
    lines[i] = out

    """if lines[i]:
      num = (i % 4)
      if num == 0:
        num = 4
      lines[i] = str(num) + ". " + lines[i]
    if i % 4 != 0:
      lines[i] = lines[i] + "& "
      lines[i] = lines[i] + "\\\\"
    """
  return s.safe_substitute(question=lines[0], answer1=lines[1],
                                              answer2=lines[2],
                                              answer3=lines[3],
                                              answer4=lines[4],
                                              actual1=lines[5],
                                              actual2=lines[6],
                                              actual3=lines[7],
                                              actual4=lines[8])

files = listdir("data")
for f in files:
  dat = open("data/" + f, 'r')
  print "%" + f
  print convert(dat.read())
