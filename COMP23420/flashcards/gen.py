"""
PLEASE DO NOT JUDGE ME ON THE CONTENTS OF THIS FILE
IT IS THE DEFINITION OF A QUICK HACK ;)
"""


from string import Template
from os import listdir
import random

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
  nlines = question.split('\n')
  nums = [1,2,3,4]
  random.shuffle(nums)
  nums2 = [nums[0] + 4,nums[1] + 4,nums[2] + 4,nums[3] + 4]
  order = nums + nums2
  index = 1
  print("%" + str(order))
  for i in order:
    out = ""
    if lines[i]:
      num = (index % 4)
      if num == 0:
        num = 4
      out = str(num) + ". & " + lines[i]
      if index % 4 != 0:
        out = out + "\\\\"  
    else:
      out = " & " 
      if index % 4 != 0:
        out = out + "\\\\"
    nlines[index] = out
    index += 1

    """if lines[i]:
      num = (i % 4)
      if num == 0:
        num = 4
      lines[i] = str(num) + ". " + lines[i]
    if i % 4 != 0:
      lines[i] = lines[i] + "& "
      lines[i] = lines[i] + "\\\\"
    """
  return s.safe_substitute(question=nlines[0], answer1=nlines[1],
                                              answer2=nlines[2],
                                              answer3=nlines[3],
                                              answer4=nlines[4],
                                              actual1=nlines[5],
                                              actual2=nlines[6],
                                              actual3=nlines[7],
                                              actual4=nlines[8])

files = listdir("data")
for f in files:
  dat = open("data/" + f, 'r')
  print("%" + f)
  print(convert(dat.read()))
