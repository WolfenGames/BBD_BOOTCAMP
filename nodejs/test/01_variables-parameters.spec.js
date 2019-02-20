import { expect, should } from 'chai';

describe('var, let, const', () => {

  describe('var...', () => {

    var name = 'abc'
    function iterator(bool) {
      if (bool) {
        var name = 'def';
      }
      return name;
    }

    it('what do you expect???', () => {
      const actual = iterator(true);

      expect(actual).equal("def");
    });
  });

  describe('let...', () => {

    let name = 'abc';
    function iterator(bool) {
      if (bool) {
        let name = 'def';
      }
      return name;
    }

    it('what do you expect???', () => {
      const actual = iterator(true);

      expect(actual).equal("abc");
    });
  });

  describe('const...', () => {
    const name = 'abc';
    function iterator(bool) {
      if (bool) {
        const name = 'def';
      }
      return name;
    }

    it('what do you expect???', () => {
      const actual = iterator(true);

      expect(actual).equal("abc");
    });
  });
});
