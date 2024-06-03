PANDO = pandoc
# FLAGS = --top-level-division=chapter --listings -r markdown-auto_identifiers -w latex -o
FLAGS = --top-level-division=chapter --listings -o

all:
	$(PANDO) Portada.md 0*.md -o Tema01.pdf --template docs/eisvogel --listings --number-sections

clean:
	rm *aux