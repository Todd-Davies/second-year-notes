#!/bin/bash
python gen.py > content.tex
pdflatex doc.tex
