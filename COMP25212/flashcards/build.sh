#!/bin/bash
for i in `ls *.tex`; do
    aspell -t check $i;
done;
pdflatex doc.tex
