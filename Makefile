day = $(shell date +'%-d')

new:
	@echo "Creating new file structure for day" $(day) "(year:" $(year)")..."

	@if [ $(day) -lt 10 ] ; then \
  		mkdir -p src/main/java/dev/Byrdman32/calendar/year$(year)/day0$(day); \
  		cd src/main/java/dev/Byrdman32/calendar/year$(year)/day0$(day); \
  		cp ../../../../../../../../template/Puzzle.java.template Puzzle.java; \
  		cp ../../../../../../../../template/README.md.template README.md; \
  	else \
  		mkdir -p src/main/java/dev/Byrdman32/calendar/year$(year)/day$(day); \
  		cd src/main/java/dev/Byrdman32/calendar/year$(year)/day$(day); \
		cp ../../../../../../../../template/Puzzle.java.template Puzzle.java; \
		cp ../../../../../../../../template/README.md.template README.md; \
    fi
	@echo "Files successfully created.. happy hacking :)"
	@echo "INFO: puzzle input will automatically be fetched/created once the program is run!"
	@git add src/main/java/dev/Byrdman32/calendar