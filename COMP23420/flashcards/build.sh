#!/bin/bash
cd data
for f in $(find . -not -name "*.bak")
do
 aspell -t check $f;
done
cd ..
aspell -t check doc.tex
python gen.py > content.tex
pdflatex doc.tex
