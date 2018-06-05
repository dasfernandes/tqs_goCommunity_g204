import { FundraiserpageModule } from './fundraiserpage.module';

describe('FundraiserpageModule', () => {
  let fundraiserpageModule: FundraiserpageModule;

  beforeEach(() => {
    fundraiserpageModule = new FundraiserpageModule();
  });

  it('should create an instance', () => {
    expect(fundraiserpageModule).toBeTruthy();
  });
});
