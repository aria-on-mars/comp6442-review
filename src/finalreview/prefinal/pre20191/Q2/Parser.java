package finalreview.prefinal.pre20191.Q2;

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
    public Screen parse() throws OutOfScreenException {
        // TODO: Add your implementation here.
        // hints: Check {@link Screen} and {@link Pointer} classes to see there is any methods/functions you can take advantage of.
		while (_tokenizer.hasNext()) {
			Token token = _tokenizer.takeNext();
			Position old = _screen.pointer.position;
			if (token.type == Token.Type.LEFT) {
				_screen.pointer.turnLeft();
			}
			else if (token.type == Token.Type.RIGHT) {
				_screen.pointer.turnRight();
			}
			else if (token.type == Token.Type.PENUP) {
				_screen.pointer.isPenDown = false;
			}
			else if (token.type == Token.Type.PENDOWN) {
				_screen.pointer.isPenDown = true;
				_screen.markVisistedPos(old);
			}
			else if (token.type == Token.Type.FORWARD) {
				switch (_screen.pointer.direction) {
					case Upward:
						_screen.pointer.position = new Position(old.x - token.value, old.y);
						break;
					case Right:
						_screen.pointer.position = new Position(old.x, old.y + token.value);
						break;
					case Left:
						_screen.pointer.position = new Position(old.x, old.y - token.value);
						break;
					case Downward:
						_screen.pointer.position = new Position(old.x + token.value, old.y);
						break;
				}
				if (_screen.pointer.isPenDown) {
					markMove(old, _screen.pointer.position);
				}
			}
			else if (token.type == Token.Type.BACK) {
				switch (_screen.pointer.direction) {
					case Upward:
						_screen.pointer.position = new Position(old.x + token.value, old.y);
						break;
					case Right:
						_screen.pointer.position = new Position(old.x, old.y - token.value);
						break;
					case Left:
						_screen.pointer.position = new Position(old.x, old.y + token.value);
						break;
					case Downward:
						_screen.pointer.position = new Position(old.x + token.value, old.y);
						break;
				}
				if (_screen.pointer.isPenDown) {
					markMove(old, _screen.pointer.position);
				}
			}
		}
 		return _screen;
	}

	private void markMove(Position old, Position moved) throws OutOfScreenException {
    	if (old.x == moved.x) {
    		markBetween(old.y, moved.y, old.x, false);
		}
    	if (old.y == moved.y) {
			markBetween(old.x, moved.x, old.y, true);
		}
	}

	private void markBetween(int start, int end, int place, boolean horizontal) throws OutOfScreenException {
    	for (int i = Math.min(start, end); i <= Math.max(start, end); ++i) {
    		if (horizontal) {
    			try {
					_screen.markVisistedPos(new Position(i, place));
				} catch (OutOfScreenException e) {

				}
			}
    		else {
				try {
					_screen.markVisistedPos(new Position(place, i));
				} catch (OutOfScreenException e) {

				}
			}
		}
	}
}
