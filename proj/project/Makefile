all:
	(cd edt-core; make $(MFLAGS) all)
	(cd edt-textui; make $(MFLAGS) all)

clean:
	(cd edt-core; make $(MFLAGS) clean)
	(cd edt-textui; make $(MFLAGS) clean)

install:
	(cd edt-core; make $(MFLAGS) install)
	(cd edt-textui; make $(MFLAGS) install)

run:	all
	(cd edt-textui; make $(MFLAGS) run)

testrun:	all
	(cd tests; ./run-all.sh)

runwithimport: all
	(cd edt-textui; make $(MFLAGS) runwithimport)

