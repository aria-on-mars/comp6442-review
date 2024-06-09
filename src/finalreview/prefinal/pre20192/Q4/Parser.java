package finalreview.prefinal.pre20192.Q4;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * @author huy.pham
 */
public class Parser {
	private Tokenizer _tokenizer;
	private Screen _screen;

	public Parser(Tokenizer tokenizer, Screen screen) {
		_tokenizer = tokenizer;
		_screen = screen;
	}

    /**
     * This should parse all the tokens, turn the pointer and mark its visited positions for
     * every move.
     *
     * If there is no more token, this should return the current screen
     *
     * @return a screen object containing pointer's trace information.
     * @throws Exception
     */
    public String positionToString(Position p) {
    	return "("+p.x +", " + p.y +")";
	}
    public Screen parse() throws OutOfScreenException {
		// TODO: Add your implementation here.
		// Hints: Check {@link Screen} and {@link Pointer} classes to see
    	//        there is any methods/functions you can take advantage of.
    	//        Check the expected outcome in ParserTest.java
    	//        You can make additional methods if needed
		do {
			Position old = new Position(_screen.pointer.position.x, _screen.pointer.position.y);
			switch (_tokenizer.current().type) {
				case BACK_TO_END:
					switch (_screen.pointer.direction) {
						case NORTH:
							_screen.pointer.position = new Position(_screen.noOfRows - 1, old.y);
							break;
						case SOUTH:
							_screen.pointer.position = new Position(0, old.y);
							break;
						case EAST:
							_screen.pointer.position = new Position(old.x, 0);
							break;
						case WEST:
							_screen.pointer.position = new Position(old.x, _screen.noOfColumns - 1);
							break;
					}
					break;
				case FORWARD_TO_END:
					switch (_screen.pointer.direction) {
						case NORTH:
							_screen.pointer.position = new Position(0, old.y);
							break;
						case SOUTH:
							_screen.pointer.position = new Position(_screen.noOfRows - 1, old.y);
							break;
						case EAST:
							_screen.pointer.position = new Position(old.x, _screen.noOfColumns - 1);
							break;
						case WEST:
							_screen.pointer.position = new Position(old.x, 0);
							break;
					}
					break;
				case RIGHT:
					_screen.pointer.turnRight();
					break;
				case LEFT:
					_screen.pointer.turnLeft();
					break;
				case BACK:
					switch (_screen.pointer.direction) {
						case NORTH:
							_screen.pointer.position = new Position(old.x + _tokenizer.current().value, old.y);
							break;
						case SOUTH:
							_screen.pointer.position = new Position(old.x - _tokenizer.current().value, old.y);
							break;
						case EAST:
							_screen.pointer.position = new Position(old.x, old.y - _tokenizer.current().value);
							break;
						case WEST:
							_screen.pointer.position = new Position(old.x, old.y + _tokenizer.current().value);
							break;
					}
					break;
				case FORWARD:
					switch (_screen.pointer.direction) {
						case NORTH:
							_screen.pointer.position = new Position(old.x - _tokenizer.current().value, old.y);
							break;
						case SOUTH:
							_screen.pointer.position = new Position(old.x + _tokenizer.current().value, old.y);
							break;
						case EAST:
							_screen.pointer.position = new Position(old.x, old.y + _tokenizer.current().value);
							break;
						case WEST:
							_screen.pointer.position = new Position(old.x, old.y - _tokenizer.current().value);
							break;
					}
					break;
				case PENUP:
					_screen.pointer.isPenDown = false;
					break;
				case PENDOWN:
					_screen.pointer.isPenDown = true;
					break;
			}
			MarkPosition(old, _screen.pointer.position, _screen.pointer.isPenDown);
			_tokenizer.next();
		} while (_tokenizer.hasNext());
		return _screen;

	}

	void MarkPosition(Position old, Position now, boolean isPenDown) throws OutOfScreenException {
    	if (!isPenDown) {
    		return;
		}
		System.out.println("Mark Positions: ");
    	if (old.x == now.x) {
    		int from = Math.min(old.y, now.y);
    		int to = Math.max(old.y, now.y);
    		for (int y = from; y <= to; ++y) {
				System.out.println(positionToString(new Position(old.x, y)));
    			_screen.markVisistedPos(new Position(old.x, y));
			}
		}
    	else {
			int from = Math.min(old.x, now.x);
			int to = Math.max(old.x, now.x);
			for (int x = from; x <= to; ++x) {
				System.out.println(positionToString(new Position(x, old.y)));
				_screen.markVisistedPos(new Position(x, old.y));
			}
		}
	}
}
