#!/bin/bash
cd data
for f in $(find . -not -name "*.bak")
do
 aspell -t check $f;
done
cd ..
python gen.py > content.tex
pdflatex doc.tex
